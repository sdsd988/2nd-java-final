package sy.testPractice.domain.application.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import sy.testPractice.domain.member.entity.Member;

import java.time.LocalTime;
import java.util.List;

import static sy.testPractice.domain.application.entity.QApplication.application;
import static sy.testPractice.domain.lecture.entity.QLecture.lecture;


@RequiredArgsConstructor
public class ApplicationRepositoryImpl implements ApplicationRepositoryCustom{

    private final JPAQueryFactory queryFactory;

//    @Override
//    public int countAllByApplyStartDateAndApplyEndDateSame(LocalDate applyStartDate, LocalDate applyEndDate) {
//        return queryFactory.selectFrom(application)
//                .leftJoin(application.lecture, lecture).fetchJoin()
//                .where(lecture.applyStartDate.eq(applyStartDate),lecture.applyEndDate.eq(applyEndDate),application.status.eq(ApplicationStatus.DONE))
//                .fetch().size();
//    }
//
//    @Override
//    public int countAllByLectureStartDateAndLectureEndDateSame(LocalDate lectureStartDate, LocalDate lectureEndDate) {
//        return queryFactory.selectFrom(application)
//                .leftJoin(application.lecture, lecture).fetchJoin()
//                .where(lecture.lectureStartDate.eq(lectureStartDate),lecture.lectureEndDate.eq(lectureEndDate),application.status.eq(ApplicationStatus.DONE))
//                .fetch().size();
//    }




    @Override
    public boolean existsByLectureStartTimeAndMember(LocalTime LectureStartTime, LocalTime LectureEndTime, Member member) {
        return queryFactory.selectFrom(application)
                .leftJoin(application.lecture,lecture).fetchJoin()
                .where(application.member.eq(member),lecture.lectureStartTime.eq(LectureStartTime),lecture.lectureEndTime.eq(LectureEndTime))
                .fetchFirst() != null;
    }

    @Override
    public boolean existsByLectureDayAndMember(String lectureDay, Member member) {
        return queryFactory.selectFrom(application)
                .leftJoin(application.lecture,lecture).fetchJoin()
                .where(application.member.eq(member),lecture.lectureDay.eq(lectureDay))
                .fetchFirst() != null;
    }
}
