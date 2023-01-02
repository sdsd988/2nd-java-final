package com.udemy.javafinal.domain.lecture.exception;

import com.udemy.javafinal.global.exception.NotFoundException;

public class LectureNotFoundException extends NotFoundException {

    public LectureNotFoundException() {
        super("강의가 존재하지 않습니다.");
    }
}
