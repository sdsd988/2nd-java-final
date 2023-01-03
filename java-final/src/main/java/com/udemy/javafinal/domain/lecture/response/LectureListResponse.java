package com.udemy.javafinal.domain.lecture.response;

import com.udemy.javafinal.domain.lecture.entity.Lecture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LectureListResponse {

    private String name;

    private String day;

    private String time;

    private int grade;

    private String prof;

    private int now_num;

    private int max_num;

    public LectureListResponse(Lecture lecture) {
        this.name = lecture.getName();
        this.day = lecture.getDayOfWeek();
        this.time = lecture.getLectureTime();
        this.grade = lecture.getGrade();
        this.prof = lecture.getProfessor();
        this.now_num = lecture.getNowStudentNum();
        this.max_num = lecture.getMaxStudentNum();
    }
}
