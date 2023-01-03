package com.udemy.javafinal.domain.enrolment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.javafinal.domain.lecture.entity.Lecture;
import com.udemy.javafinal.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Enrolment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrolment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Lecture lecture;

    @Enumerated(EnumType.STRING)
    private STATUS status;

    public enum STATUS {
        BASKET, COMPLETION, LIKED
    }

    public Enrolment(Member member, Lecture lecture, STATUS status) {
        this.member = member;
        this.lecture = lecture;
        this.status = status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}
