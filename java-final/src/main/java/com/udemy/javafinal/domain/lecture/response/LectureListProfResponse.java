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
public class LectureListProfResponse {

    private String name;

    private String day;

    private String time;

    private int now_num;

    private int max_num;

    public LectureListProfResponse(Lecture lecture) {
        this.name = lecture.getName();
        this.day = lecture.getDayOfWeek();
        this.time = lecture.getLectureTime();
        this.now_num = lecture.getNowStudentNum();
        this.max_num = lecture.getMaxStudentNum();
    }
}
