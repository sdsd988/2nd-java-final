package com.udemy.javafinal.domain.lecture.repository;

import com.udemy.javafinal.domain.lecture.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findAll();

    List<Lecture> findLecturesByIdentificationNum(String identificationNum);
}
