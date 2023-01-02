package com.udemy.javafinal.domain.lecture.controller;

import com.udemy.javafinal.domain.lecture.response.LectureListProfResponse;
import com.udemy.javafinal.domain.lecture.response.LectureListResponse;
import com.udemy.javafinal.domain.lecture.service.LectureService;
import com.udemy.javafinal.global.response.DefaultResult;
import com.udemy.javafinal.global.response.StatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping("/lecture")
    public DefaultResult lectureList() {
        List<LectureListResponse> lectureListRespons = lectureService.lectureList();
        return new DefaultResult(StatusCode.OK, "강의 리스트 조회", lectureListRespons);
    }

    @GetMapping("/lecture/{identificationNum}")
    public DefaultResult lectureListByIdentificationNum(@PathVariable String identificationNum) {
        List<LectureListProfResponse> lectureListProfResponses = lectureService.lectureListByProf(identificationNum);
        return new DefaultResult(StatusCode.OK, "강의 리스트 조회 - 교수자", lectureListProfResponses);
    }
}
