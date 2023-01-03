package com.udemy.javafinal.domain.enrolment.exception;

import com.udemy.javafinal.global.exception.ForbiddenException;

public class EnrolmentInvalidPeriodException extends ForbiddenException {

    public EnrolmentInvalidPeriodException() {
        super("수강 신청 기간이 아닙니다.");
    }
}
