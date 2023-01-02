package sy.testPractice.domain.lecture.repository;

import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sy.testPractice.domain.lecture.entity.Lecture;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface LectureRepository extends JpaRepository<Lecture,Long> {

   Optional<Lecture> findByLectureName(String lectureName);


}
