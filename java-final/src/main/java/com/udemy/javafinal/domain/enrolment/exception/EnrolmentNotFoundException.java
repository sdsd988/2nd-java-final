package com.udemy.javafinal.domain.enrolment.exception;

import com.udemy.javafinal.global.exception.NotFoundException;

public class EnrolmentNotFoundException extends NotFoundException {

    public EnrolmentNotFoundException() {
        super("수강 신청 내역이 존재하지 않습니다.");
    }
}
