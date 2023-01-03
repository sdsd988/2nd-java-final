package com.udemy.javafinal.global.error;

import com.udemy.javafinal.domain.enrolment.exception.BasketInvalidPeriodException;
import com.udemy.javafinal.domain.enrolment.exception.EnrolmentInvalidException;
import com.udemy.javafinal.domain.enrolment.exception.EnrolmentInvalidPeriodException;
import com.udemy.javafinal.domain.enrolment.exception.EnrolmentNotFoundException;
import com.udemy.javafinal.domain.lecture.exception.LectureNotFoundException;
import com.udemy.javafinal.domain.member.exception.MemberNotFoundException;
import com.udemy.javafinal.global.exception.NotFoundException;
import com.udemy.javafinal.global.response.DefaultResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler
    protected DefaultResult BasketInvalidPeriodException(BasketInvalidPeriodException e){
        return new DefaultResult(403, "BasketInvalidPeriodException Error!", e.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler
    protected DefaultResult EnrolmentInvalidException(EnrolmentInvalidException e){
        return new DefaultResult(403, "EnrolmentInvalidException Error!", e.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler
    protected DefaultResult EnrolmentInvalidPeriodException(EnrolmentInvalidPeriodException e){
        return new DefaultResult(403, "EnrolmentInvalidPeriodException Error!", e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    protected DefaultResult NotFoundException(NotFoundException e){
        return new DefaultResult(404, "NotFoundException Error!", e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    protected DefaultResult MemberNotFoundException(MemberNotFoundException e){
        return new DefaultResult(404, "MemberNotFoundException Error!", e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    protected DefaultResult LectureNotFoundException(LectureNotFoundException e){
        return new DefaultResult(404, "LectureNotFoundException Error!", e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    protected DefaultResult EnrolmentNotFoundException(EnrolmentNotFoundException e){
        return new DefaultResult(404, "EnrolmentNotFoundException Error!", e.getMessage());
    }
}
