package sy.testPractice.domain.lecture.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sy.testPractice.domain.application.entity.Application;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mainProfessor;

    private String lectureInfo;

    private String lectureName;

    private int maxStudent;

    private int score;

    private String lectureDay;

    private LocalTime lectureStartTime;

    private LocalTime lectureEndTime;

    /**
     * 모집 기간
     */
    private LocalDateTime applyStartDate;

    private LocalDateTime applyEndDate;

    /**
     * 장바구니 기간
     */

    private LocalDateTime lectureReserveStartDate;

    private LocalDateTime lectureReserveEndDate;


    @JsonManagedReference
    @OneToMany(mappedBy = "lecture")
    private List<Application> applications = new ArrayList<>();

    public Lecture(String mainProfessor, String lectureInfo, String lectureName, int maxStudent, int score, String lectureDay, LocalTime lectureStartTime, LocalTime lectureEndTime, LocalDateTime applyStartDate, LocalDateTime applyEndDate, LocalDateTime lectureReserveStartDate, LocalDateTime lectureReserveEndDate) {
        this.mainProfessor = mainProfessor;
        this.lectureInfo = lectureInfo;
        this.lectureName = lectureName;
        this.maxStudent = maxStudent;
        this.score = score;
        this.lectureDay = lectureDay;
        this.lectureStartTime = lectureStartTime;
        this.lectureEndTime = lectureEndTime;
        this.applyStartDate = applyStartDate;
        this.applyEndDate = applyEndDate;
        this.lectureReserveStartDate = lectureReserveStartDate;
        this.lectureReserveEndDate = lectureReserveEndDate;
    }
}
