package sy.testPractice.domain.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sy.testPractice.domain.application.entity.Application;
import sy.testPractice.domain.application.entity.ApplicationStatus;
import sy.testPractice.domain.application.exception.ApplicationNotFoundException;
import sy.testPractice.domain.application.repository.ApplicationRepository;
import sy.testPractice.domain.application.request.ApplicationSaveRequestDto;
import sy.testPractice.domain.application.response.ApplicationAdminResponseDto;
import sy.testPractice.domain.lecture.entity.Lecture;
import sy.testPractice.domain.lecture.exception.LectureNotFoundException;
import sy.testPractice.domain.lecture.repository.LectureRepository;
import sy.testPractice.domain.member.entity.Member;
import sy.testPractice.domain.member.exception.MemberNotFoundException;
import sy.testPractice.domain.member.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ApplicationService {

    private final MemberRepository memberRepository;
    private final LectureRepository lectureRepository;
    private final ApplicationRepository applicationRepository;

    /**
     * 수강 신청 기간이 종료되면, 장바구니 혹은 찜 상태의 지원서는 모두 삭제됩니다.
     */
    public void setTimeExpireApplication() {
        ArrayList<ApplicationStatus> statusList = new ArrayList<>();
        statusList.add(ApplicationStatus.CART);
        statusList.add(ApplicationStatus.RESERVE);

        List<Application> applicationList = applicationRepository.findApplicationsByStatusIn(statusList);
        for (int i = 0; i < applicationList.size(); i++) {
            Application application = applicationList.get(i);
            if (application.getLecture().getApplyEndDate().isBefore(LocalDateTime.now())) {
                applicationList.set(i, application);
            }
        }
        applicationRepository.deleteAll(applicationList);
    }

    //장바구니
    @Transactional
    public synchronized int reserveApplication(Long memberId, ApplicationSaveRequestDto applicationSaveRequestDto) {

        Member applyMember = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        Lecture applyLecture = lectureRepository.findByLectureName(applicationSaveRequestDto.getLectureName()).orElseThrow(LectureNotFoundException::new);

        int comStudents = applicationRepository.countApplicationByLectureAndStatusIs(applyLecture, ApplicationStatus.COMPLETE);


        List<Application> applications = applicationRepository.findAllByMemberAndLecture(applyMember, applyLecture);
        for (Application application : applications) {
            if (application.getStatus() == ApplicationStatus.COMPLETE) return 5;
        }
        //제출 기한 여부 확인
        if (LocalDateTime.now().isBefore(applyLecture.getLectureReserveStartDate()) || LocalDateTime.now().isAfter(applyLecture.getLectureReserveEndDate())) {
            return 2;
        } else if(applicationRepository.existsByLectureDayAndMember(applyLecture.getLectureDay(), applyMember)
        && applicationRepository.existsByLectureStartTimeAndMember(applyLecture.getLectureStartTime(),applyLecture.getLectureEndTime(),applyMember)){
            return 3;
        } else if(applyLecture.getMaxStudent()<=comStudents){
            Application application = new Application(applyMember, applyLecture, ApplicationStatus.RESERVE);
            applicationRepository.save(application);
            return 4;
        }

        Application application = new Application(applyMember, applyLecture, ApplicationStatus.COMPLETE);

        applicationRepository.save(application);

        return 1;
    }

    //본 수강 신청

    @Transactional
    public synchronized int submitApplication(Long memberId, ApplicationSaveRequestDto applicationSaveRequestDto) {

        Member findStudent = memberRepository.findById(memberId).orElseThrow();
        Lecture applyLecture = lectureRepository.findByLectureName(applicationSaveRequestDto.getLectureName()).orElseThrow(LectureNotFoundException::new);

        int comStudents = applicationRepository.countApplicationByLectureAndStatusIs(applyLecture, ApplicationStatus.COMPLETE);
        int totalScore = 0;
        List<Application> findApplication = applicationRepository.findByMemberId(findStudent.getId());
        for (Application application : findApplication) {
            totalScore += application.getLecture().getScore();
        }

        // 최종 지원완료 지원서는 1개만 존재
        List<Application> applications = applicationRepository.findAllByMemberAndLecture(findStudent, applyLecture);
        for (Application application : applications) {
            if (application.getStatus() == ApplicationStatus.COMPLETE) return 2;
        }

        if (LocalDateTime.now().isBefore(applyLecture.getApplyStartDate()) || LocalDateTime.now().isAfter(applyLecture.getApplyEndDate())) {
            return 6;
        } else if(applyLecture.getMaxStudent() < comStudents ){
            return 3;
        //최대 학점 조건
        } else if(totalScore+applyLecture.getScore()>21){
            return 4;
        //요일/시간 조건
        } else if(applicationRepository.existsByLectureDayAndMember(applyLecture.getLectureDay(), findStudent)&&applicationRepository.existsByLectureStartTimeAndMember(applyLecture.getLectureStartTime(),applyLecture.getLectureEndTime(),findStudent)){
            return 5;
        }


        Application application = new Application(findStudent, applyLecture, ApplicationStatus.COMPLETE);

        applicationRepository.save(application);

        return 1;
    }

    //수강신청 취소
    @Transactional
    public synchronized int removeApplication(Long applicationId) {
        Application findApplication = applicationRepository.findById(applicationId).orElseThrow(ApplicationNotFoundException::new);


        applicationRepository.delete(findApplication);

        return 1;
    }



   // 과목별 지원서 조회 - 관리자
    public List<ApplicationAdminResponseDto> getLectureApplicationByAdmin(String lectureName) {
        Lecture findLecture = lectureRepository.findByLectureName(lectureName).orElseThrow(LectureNotFoundException::new);
        List<Application> findApp = applicationRepository.findApplicationByLecture(findLecture);
        return findApp.stream().map(ApplicationAdminResponseDto::new).collect(Collectors.toList());

    }




}
