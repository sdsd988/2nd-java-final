package com.udemy.javafinal.domain.enrolment.repository;

import com.udemy.javafinal.domain.enrolment.entity.Enrolment;
import com.udemy.javafinal.domain.lecture.entity.Lecture;
import com.udemy.javafinal.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {

    List<Enrolment> findAll();

    Optional<Enrolment> findEnrolmentByLecture(Lecture lecture);

    Optional<Enrolment> findEnrolmentByMemberAndLecture(Member member, Lecture lecture);
}
