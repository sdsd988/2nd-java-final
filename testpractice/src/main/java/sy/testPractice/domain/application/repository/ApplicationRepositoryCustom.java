package sy.testPractice.domain.application.repository;

import sy.testPractice.domain.member.entity.Member;

import java.time.LocalTime;
import java.util.List;

public interface ApplicationRepositoryCustom {

//
//    int countAllByApplyStartDateAndApplyEndDateSame(LocalDate applyStartDate, LocalDate applyEndDate);
//
//    int countAllByLectureStartDateAndLectureEndDateSame(LocalDate lectureStartDate, LocalDate lectureEndDate);


    boolean existsByLectureStartTimeAndMember(LocalTime LectureStartTime, LocalTime LectureEndTime, Member member);

    boolean existsByLectureDayAndMember(String lectureDay, Member member);


}
