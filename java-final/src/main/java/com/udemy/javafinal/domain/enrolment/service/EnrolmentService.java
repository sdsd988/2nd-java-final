package com.udemy.javafinal.domain.enrolment.service;

import com.udemy.javafinal.domain.enrolment.entity.Enrolment;
import com.udemy.javafinal.domain.enrolment.exception.BasketInvalidPeriodException;
import com.udemy.javafinal.domain.enrolment.exception.EnrolmentInvalidException;
import com.udemy.javafinal.domain.enrolment.exception.EnrolmentInvalidPeriodException;
import com.udemy.javafinal.domain.enrolment.exception.EnrolmentNotFoundException;
import com.udemy.javafinal.domain.enrolment.repository.EnrolmentRepository;
import com.udemy.javafinal.domain.lecture.entity.Lecture;
import com.udemy.javafinal.domain.lecture.exception.LectureNotFoundException;
import com.udemy.javafinal.domain.lecture.repository.LectureRepository;
import com.udemy.javafinal.domain.member.entity.Member;
import com.udemy.javafinal.domain.member.exception.MemberNotFoundException;
import com.udemy.javafinal.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
@Transactional
public class EnrolmentService {

    private final EnrolmentRepository enrolmentRepository;
    private final MemberRepository memberRepository;
    private final LectureRepository lectureRepository;

    public EnrolmentService(EnrolmentRepository enrolmentRepository, MemberRepository memberRepository, LectureRepository lectureRepository) {
        this.enrolmentRepository = enrolmentRepository;
        this.memberRepository = memberRepository;
        this.lectureRepository = lectureRepository;
    }

    final LocalDateTime now = LocalDateTime.now();
    final LocalDateTime startBasket = LocalDateTime.of(2023, 1, 9, 14, 0);
    final LocalDateTime endBasket = LocalDateTime.of(2023, 1, 10, 18, 0);
    final LocalDateTime startEnrolment = LocalDateTime.of(2023, 1, 11, 14, 0);
    final LocalDateTime endEnrolment = LocalDateTime.of(2023, 1, 11, 18, 0);

    //사전수강신청 (장바구니)
    public void preEnrol(Long memberId, Long lectureId) {
        Member member = getMember(memberId);
        Lecture lecture = getLecture(lectureId);

        List<Enrolment> enrolmentList = member.getEnrolmentList();
        List<Lecture> lectureList = new ArrayList<>();
        for (Enrolment enrolment : enrolmentList) {
            lectureList.add(enrolment.getLecture());
        }

        if(now.isAfter(startBasket) && now.isBefore(endBasket)) {
            boolean canEnrolCheck = validLectureDayAndTime(lecture, lectureList);
            if(canEnrolCheck == true) {
                Enrolment enrolment = new Enrolment(member, lecture, Enrolment.STATUS.BASKET);
                enrolmentList.add(enrolment);
                lecture.plusNowStudentNum();
            } else {
                throw new EnrolmentInvalidException();
            }
        } else {
            throw new BasketInvalidPeriodException();
        }
    }

    private Member getMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);
        return member;
    }

    private Lecture getLecture(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(LectureNotFoundException::new);
        return lecture;
    }

    private static boolean validLectureDayAndTime(Lecture lecture, List<Lecture> lectureList) {
        for (Lecture enroledLecture : lectureList) {
            if(enroledLecture.getDayOfWeek().equals(lecture.getDayOfWeek())
             && enroledLecture.getLectureTime().equals(lecture.getLectureTime())) {
                return false;
            }
        }
        return true;
    }

    public void cancelPreEnrolment(Long memberId, Long lectureId) {
        Member member = getMember(memberId);
        Lecture lecture = getLecture(lectureId);

        if(now.isAfter(startBasket) && now.isBefore(endBasket)) {
            Enrolment enrolmentByMemberAndLecture = enrolmentRepository.findEnrolmentByMemberAndLecture(member, lecture)
                    .orElseThrow(EnrolmentNotFoundException::new);
            enrolmentRepository.delete(enrolmentByMemberAndLecture);
            lecture.minusNowStudentNum();
        } else {
            throw new BasketInvalidPeriodException();
        }
    }

    //본 수강신청
    public void realEnrol(Long memberId, Long lectureId) {
        Member member = getMember(memberId);
        Lecture lecture = getLecture(lectureId);
        List<Enrolment> enrolmentList = member.getEnrolmentList();
        List<Lecture> lectureList = new ArrayList<>();
        for (Enrolment enrolment : enrolmentList) {
            lectureList.add(enrolment.getLecture());
        }

        if(now.isAfter(startEnrolment) && now.isBefore(endEnrolment)) {
            if(validLectureDayAndTime(lecture, lectureList)
                    && isUnderGrade(member, lecture)
                    && isUnderMaxStudentNum(lecture)) {
                Enrolment enrolment = new Enrolment(member, lecture, Enrolment.STATUS.COMPLETION);
                enrolmentList.add(enrolment);
                lecture.plusNowStudentNum();
                member.plusGrade(lecture.getGrade());
                memberRepository.save(member);
            } else {
                throw new EnrolmentInvalidException();
            }
        } else {
            throw new EnrolmentInvalidPeriodException();
        }
    }

    private static boolean isUnderGrade(Member member, Lecture lecture) {
        if(member.getGrade() + lecture.getGrade() >= 21) {
            return false;
        }
        return true;
    }

    private static boolean isUnderMaxStudentNum(Lecture lecture) {
        if(lecture.getNowStudentNum() == lecture.getMaxStudentNum()) {
            return false;
        }
        return true;
    }

    public void cancelRealEnrolment(Long memberId, Long lectureId) {
        Member member = getMember(memberId);
        Lecture lecture = getLecture(lectureId);

        if(now.isAfter(startEnrolment) && now.isBefore(endEnrolment)) {
            Enrolment enrolmentByMemberAndLecture = enrolmentRepository.findEnrolmentByMemberAndLecture(member, lecture)
                    .orElseThrow(EnrolmentNotFoundException::new);
            enrolmentRepository.delete(enrolmentByMemberAndLecture);
            lecture.minusNowStudentNum();
            member.minusGrade(lecture.getGrade());
            memberRepository.save(member);
        } else {
            throw new EnrolmentInvalidPeriodException();
        }
    }

    //사전수강신청 기간이 지나면 실행
    public void afterBasketPeriod() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                endBasketPeriod();
            }
        };

        Timer timer = new Timer();
        Date date = Date.from(endBasket.atZone(
                ZoneId.systemDefault()).toInstant());
        timer.schedule(task, date);
    }

    //사전수강신청 기간 지났을때 처리
    public void endBasketPeriod() {
        if(now.isAfter(endBasket)) {
            List<Lecture> all = lectureRepository.findAll();
            for (Lecture lecture : all) {
                if(lecture.getNowStudentNum() < lecture.getMaxStudentNum()) {
                    Enrolment enrolmentByLecture = enrolmentRepository.findEnrolmentByLecture(lecture)
                            .orElseThrow(EnrolmentNotFoundException::new);
                    enrolmentByLecture.setStatus(Enrolment.STATUS.COMPLETION);
                    Member member = enrolmentByLecture.getMember();
                    member.plusGrade(lecture.getGrade());
                    memberRepository.save(member);
                } else {
                    Enrolment enrolmentByLecture = enrolmentRepository.findEnrolmentByLecture(lecture)
                            .orElseThrow(EnrolmentNotFoundException::new);
                    enrolmentByLecture.setStatus(Enrolment.STATUS.LIKED);
                }
            }
        }
    }
}
