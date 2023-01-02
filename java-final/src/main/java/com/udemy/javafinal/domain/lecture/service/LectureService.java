package com.udemy.javafinal.domain.lecture.service;

import com.udemy.javafinal.domain.lecture.repository.LectureRepository;
import com.udemy.javafinal.domain.lecture.response.LectureListProfResponse;
import com.udemy.javafinal.domain.lecture.response.LectureListResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class LectureService {

    private final LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public List<LectureListResponse> lectureList() {
        return lectureRepository.findAll()
                .stream()
                .map(LectureListResponse::new)
                .collect(Collectors.toList());
    }

    public List<LectureListProfResponse> lectureListByProf(@PathVariable String identificationNum) {
        return lectureRepository.findLecturesByIdentificationNum(identificationNum)
                .stream()
                .map(LectureListProfResponse::new)
                .collect(Collectors.toList());
    }
}
