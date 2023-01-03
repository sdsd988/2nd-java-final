package com.udemy.javafinal.domain.enrolment.controller;

import com.udemy.javafinal.domain.enrolment.reponse.EnrolmentRequestDto;
import com.udemy.javafinal.domain.enrolment.service.EnrolmentService;
import com.udemy.javafinal.global.response.DefaultResult;
import com.udemy.javafinal.global.response.StatusCode;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/enrolment")
public class EnrolmentController {

    private final EnrolmentService enrolmentService;

    public EnrolmentController(EnrolmentService enrolmentService) {
        this.enrolmentService = enrolmentService;
    }

    @PostMapping("/pre")
    public DefaultResult preEnrolment(@RequestBody EnrolmentRequestDto enrolmentRequestDto) {
        enrolmentService.preEnrol(enrolmentRequestDto.getMemberId(),
                enrolmentRequestDto.getLectureId());
        return new DefaultResult(StatusCode.OK, "사전수강신청 완료");
    }

    @DeleteMapping("/pre")
    public DefaultResult cancelPreEnrolment(@RequestBody EnrolmentRequestDto enrolmentRequestDto) {
        enrolmentService.cancelPreEnrolment(enrolmentRequestDto.getMemberId(),
                enrolmentRequestDto.getLectureId());
        return new DefaultResult(StatusCode.OK, "사전수강신청 취소 완료");
    }

    @PostMapping("/real")
    public DefaultResult realEnrolment(@RequestBody EnrolmentRequestDto enrolmentRequestDto) {
        enrolmentService.realEnrol(enrolmentRequestDto.getMemberId(),
                enrolmentRequestDto.getLectureId());
        return new DefaultResult(StatusCode.OK, "본수강신청 완료");
    }

    @DeleteMapping("/real")
    public DefaultResult cancelRealEnrolment(@RequestBody EnrolmentRequestDto enrolmentRequestDto) {
        enrolmentService.cancelRealEnrolment(enrolmentRequestDto.getMemberId(),
                enrolmentRequestDto.getLectureId());
        return new DefaultResult(StatusCode.OK, "본수강신청 취소 완료");
    }
}
