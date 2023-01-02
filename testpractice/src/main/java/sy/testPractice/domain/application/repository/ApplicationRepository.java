package sy.testPractice.domain.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sy.testPractice.domain.application.entity.Application;
import sy.testPractice.domain.application.entity.ApplicationStatus;
import sy.testPractice.domain.lecture.entity.Lecture;
import sy.testPractice.domain.member.entity.Member;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long>,ApplicationRepositoryCustom {

    List<Application> findByMemberId(Long memberId);




    List<Application> findApplicationsByStatusIn(List<ApplicationStatus> statusList);

    List<Application> findAllByMemberAndLecture(Member member, Lecture lecture);

    List<Application> findApplicationByLecture(Lecture lecture);



//
//    boolean existsByLectureEndTimeAndMember(LocalTime LectureEndTime, Member member);

    int countApplicationByLectureAndStatusIs(Lecture lecture, ApplicationStatus status);

    int countApplicationByMemberAndStatusIsNot(Member member,ApplicationStatus status);

    List<Application> findAllByMemberAndStatus(Member member, ApplicationStatus applicationStatus);


}
