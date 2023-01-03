package com.udemy.javafinal.domain.member.entity;

import com.udemy.javafinal.domain.enrolment.entity.Enrolment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private ROLE role;

    private String identificationNum;

    private int grade = 0;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Enrolment> enrolmentList;

    public Member(String email, String password, String name, ROLE role, String identificationNum) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.identificationNum = identificationNum;
    }

    public enum ROLE {
        PROFESSOR, STUDENT
    }

    public void plusGrade(int grade) {
        this.grade += grade;
    }

    public void minusGrade(int grade) {
        this.grade -= grade;
    }
}
