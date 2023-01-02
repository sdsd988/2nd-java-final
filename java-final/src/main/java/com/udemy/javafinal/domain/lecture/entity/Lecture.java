package com.udemy.javafinal.domain.lecture.entity;

import com.udemy.javafinal.domain.enrolment.entity.Enrolment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;

    private String name;

    private String professor;

    private String dayOfWeek;

    private String lectureTime;

    private int maxStudentNum;

    private int nowStudentNum = 0;

    private int grade;

    private String identificationNum;

    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Enrolment> enrolmentList;

    public Lecture(String name, String professor, String dayOfWeek, String lectureTime, int maxStudentNum, int grade, String identificationNum) {
        this.name = name;
        this.professor = professor;
        this.dayOfWeek = dayOfWeek;
        this.lectureTime = lectureTime;
        this.maxStudentNum = maxStudentNum;
        this.grade = grade;
        this.identificationNum = identificationNum;
    }

    public void plusNowStudentNum() {
        this.nowStudentNum++;
    }

    public void minusNowStudentNum() {
        this.nowStudentNum--;
    }
}
