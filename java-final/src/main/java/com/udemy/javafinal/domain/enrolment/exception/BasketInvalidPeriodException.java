package com.udemy.javafinal.domain.enrolment.exception;

import com.udemy.javafinal.global.exception.ForbiddenException;

public class BasketInvalidPeriodException extends ForbiddenException {

    public BasketInvalidPeriodException() {
        super("사전 수강 신청 기간이 아닙니다.");
    }
}
