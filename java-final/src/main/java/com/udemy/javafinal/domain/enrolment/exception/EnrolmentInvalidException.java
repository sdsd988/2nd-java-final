package com.udemy.javafinal.domain.enrolment.exception;

import com.udemy.javafinal.global.exception.ForbiddenException;

public class EnrolmentInvalidException extends ForbiddenException {

    public EnrolmentInvalidException() {
        super("요일과 시간이 겹쳐서 신청할 수 없습니다.");
    }
}
