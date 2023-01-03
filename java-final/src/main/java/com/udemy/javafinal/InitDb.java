package com.udemy.javafinal;

import com.udemy.javafinal.domain.enrolment.service.EnrolmentService;
import com.udemy.javafinal.domain.lecture.entity.Lecture;
import com.udemy.javafinal.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
public class InitDb {

    private final InitService initService;
    private final EnrolmentService enrolmentService;

    public InitDb(InitService initService, EnrolmentService enrolmentService) {
        this.initService = initService;
        this.enrolmentService = enrolmentService;
    }

    @PostConstruct
    public void init() {
        enrolmentService.afterBasketPeriod();
        initService.dbMember();
        initService.dbLecture();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;
        public void dbMember() {
            Member member1 = new Member("test1@test1",
                    "test1",
                    "member1",
                    Member.ROLE.STUDENT,
                    "0001");

            Member member2 = new Member("test2@test2",
                    "test2",
                    "member2",
                    Member.ROLE.STUDENT,
                    "0002");

            Member member3 = new Member("test3@test3",
                    "test3",
                    "member3",
                    Member.ROLE.STUDENT,
                    "0003");

            Member member4 = new Member("test4@test4",
                    "test4",
                    "member4",
                    Member.ROLE.STUDENT,
                    "0004");

            Member member5 = new Member("test5@test5",
                    "test5",
                    "member5",
                    Member.ROLE.STUDENT,
                    "0005");

            Member member6 = new Member("test6@test6",
                    "test6",
                    "member6",
                    Member.ROLE.STUDENT,
                    "0006");

            Member member7 = new Member("test7@test7",
                    "test7",
                    "member7",
                    Member.ROLE.STUDENT,
                    "0007");

            Member member8 = new Member("test8@test8",
                    "test8",
                    "prof1",
                    Member.ROLE.PROFESSOR,
                    "0008");

            Member member9 = new Member("test9@test9",
                    "test9",
                    "prof2",
                    Member.ROLE.PROFESSOR,
                    "0009");

            Member member10 = new Member("test10@test10",
                    "test10",
                    "prof3",
                    Member.ROLE.PROFESSOR,
                    "0010");

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);
            em.persist(member5);
            em.persist(member6);
            em.persist(member7);
            em.persist(member8);
            em.persist(member9);
            em.persist(member10);
        }

        public void dbLecture() {
            Lecture lecture1 = new Lecture("lecture1",
                    "prof1",
                    "월",
                    "9:00",
                    5,
                    3,
                    "0008");

            Lecture lecture2 = new Lecture("lecture2",
                    "prof2",
                    "화",
                    "9:00",
                    5,
                    3,
                    "0009");

            Lecture lecture3 = new Lecture("lecture3",
                    "prof3",
                    "수",
                    "9:00",
                    5,
                    3,
                    "0010");

            Lecture lecture4 = new Lecture("lecture4",
                    "prof1",
                    "목",
                    "9:00",
                    5,
                    3,
                    "0008");

            Lecture lecture5 = new Lecture("lecture5",
                    "prof2",
                    "금",
                    "9:00",
                    5,
                    3,
                    "0009");

            Lecture lecture6 = new Lecture("lecture6",
                    "prof3",
                    "월",
                    "11:00",
                    5,
                    3,
                    "0010");

            Lecture lecture7 = new Lecture("lecture7",
                    "prof2",
                    "화",
                    "11:00",
                    5,
                    3,
                    "0009");

            Lecture lecture8 = new Lecture("lecture8",
                    "prof3",
                    "수",
                    "11:00",
                    5,
                    3,
                    "0010");

            Lecture lecture9 = new Lecture("lecture9",
                    "prof2",
                    "월",
                    "9:00",
                    5,
                    3,
                    "0009");

            Lecture lecture10 = new Lecture("lecture10",
                    "prof3",
                    "화",
                    "9:00",
                    5,
                    3,
                    "0010");

            Lecture lecture11 = new Lecture("lecture11",
                    "prof2",
                    "수",
                    "14:00",
                    5,
                    3,
                    "0009");

            Lecture lecture12 = new Lecture("lecture12",
                    "prof1",
                    "목",
                    "12:00",
                    5,
                    3,
                    "0008");

            Lecture lecture13 = new Lecture("lecture13",
                    "prof2",
                    "금",
                    "13:00",
                    5,
                    3,
                    "0009");

            Lecture lecture14 = new Lecture("lecture14",
                    "prof1",
                    "월",
                    "15:00",
                    5,
                    3,
                    "0008");

            Lecture lecture15 = new Lecture("lecture15",
                    "prof2",
                    "화",
                    "15:00",
                    5,
                    3,
                    "0009");

            em.persist(lecture1);
            em.persist(lecture2);
            em.persist(lecture3);
            em.persist(lecture4);
            em.persist(lecture5);
            em.persist(lecture6);
            em.persist(lecture7);
            em.persist(lecture8);
            em.persist(lecture9);
            em.persist(lecture10);
            em.persist(lecture11);
            em.persist(lecture12);
            em.persist(lecture13);
            em.persist(lecture14);
            em.persist(lecture15);
        }
    }
}
