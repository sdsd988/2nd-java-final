package com.udemy.javafinal.domain.enrolment.reponse;

import com.udemy.javafinal.domain.enrolment.entity.Enrolment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrolmentListResponse {

    private String studentName;

    private String studentNum;

    private String lectureName;

    private String lectureProf;

    private String lectureDay;

    private String lectureTime;

    private int lectureNowStudentNum;

    private int lectureMaxStudentNum;

    private int lectureGrade;

    public EnrolmentListResponse(Enrolment enrolment) {
        this.studentName = enrolment.getMember().getName();
        this.studentNum = enrolment.getMember().getIdentificationNum();
        this.lectureName = enrolment.getLecture().getName();
        this.lectureProf = enrolment.getLecture().getProfessor();
        this.lectureDay = enrolment.getLecture().getDayOfWeek();
        this.lectureTime = enrolment.getLecture().getLectureTime();
        this.lectureNowStudentNum = enrolment.getLecture().getNowStudentNum();
        this.lectureMaxStudentNum = enrolment.getLecture().getMaxStudentNum();
        this.lectureGrade = enrolment.getLecture().getGrade();
    }
}
