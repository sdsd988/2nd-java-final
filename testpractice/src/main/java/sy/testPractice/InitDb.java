package sy.testPractice;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sy.testPractice.domain.lecture.entity.Lecture;
import sy.testPractice.domain.member.entity.Member;
import sy.testPractice.domain.member.entity.MemberRole;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.doInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void doInit1() {

            Member member1 = new Member("member1@email","1234","kim","철학과","11110",21, MemberRole.STUDENT);
            Member member2 = new Member("member2@email","1234","lee","물리학과","11111",21, MemberRole.STUDENT);
            Member member3 = new Member("member3@email","1234","jung","생물학과","11112",21, MemberRole.STUDENT);
            Member member4 = new Member("member4@email","1234","park","경영과","11113",21, MemberRole.STUDENT);
            Member member5 = new Member("member5@email","1234","yun","해양과","11114",21, MemberRole.STUDENT);
            Member member6 = new Member("member6@email","1234","jo","컴공과","11115",21, MemberRole.STUDENT);
            Member member7 = new Member("member7@email","1234","hong","컴공과","11116",21, MemberRole.PROFESSOR);
            Member member8 = new Member("member8@email","1234","song","컴공과","11117",21, MemberRole.PROFESSOR);
            Member member9 = new Member("member9@email","1234","blanc","컴공과","11118",21, MemberRole.PROFESSOR);
            Member member10 = new Member("member10@email","1234","phone","컴공과","11119",21, MemberRole.PROFESSOR);


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

            Lecture lecture1 = new Lecture("blanc","컴퓨터공학","자료구조", 1, 3, "화요일", LocalTime.of(10,0),LocalTime.of(13,0), LocalDateTime.of(2023,1,11,14,0),
                    LocalDateTime.of(2023,1,11,18,0),LocalDateTime.of(2023,1,1,14,0),
                    LocalDateTime.of(2023,1,10,18,0));

            Lecture lecture2 = new Lecture("phone","컴퓨터공학","JAVA", 5, 3, "화요일", LocalTime.of(10,0),LocalTime.of(13,0), LocalDateTime.of(2023,1,11,14,0),
                    LocalDateTime.of(2023,1,11,18,0),LocalDateTime.of(2023,1,1,10,0),
                    LocalDateTime.of(2023,1,10,18,0));

            Lecture lecture3 = new Lecture("song","컴퓨터공학","JS", 5, 3, "수요일", LocalTime.of(10,0),LocalTime.of(13,0), LocalDateTime.of(2023,1,11,14,0),
                    LocalDateTime.of(2023,1,11,18,0),LocalDateTime.of(2023,1,9,14,0),
                    LocalDateTime.of(2023,1,10,18,0));

            Lecture lecture4 = new Lecture("hong","컴퓨터공학","SPRING", 5, 3, "목요일", LocalTime.of(10,0),LocalTime.of(13,0), LocalDateTime.of(2023,1,11,14,0),
                    LocalDateTime.of(2023,1,11,18,0),LocalDateTime.of(2023,1,9,14,0),
                    LocalDateTime.of(2023,1,10,18,0));

            Lecture lecture5 = new Lecture("hong","컴퓨터공학","NODE", 5, 3, "화요일", LocalTime.of(10,0),LocalTime.of(13,0), LocalDateTime.of(2023,1,11,14,0),
                    LocalDateTime.of(2023,1,11,18,0),LocalDateTime.of(2023,1,9,14,0),
                    LocalDateTime.of(2023,1,10,18,0));

            Lecture lecture6 = new Lecture("lion","컴퓨터공학","알고리즘", 5, 3, "금요일", LocalTime.of(10,0),LocalTime.of(13,0), LocalDateTime.of(2023,1,11,14,0),
                    LocalDateTime.of(2023,1,11,18,0),LocalDateTime.of(2023,1,9,14,0),
                    LocalDateTime.of(2023,1,10,18,0));

            Lecture lecture7 = new Lecture("tiger","컴퓨터공학","수학", 5, 3, "화요일", LocalTime.of(10,0),LocalTime.of(13,0), LocalDateTime.of(2023,1,11,14,0),
                    LocalDateTime.of(2023,1,11,18,0),LocalDateTime.of(2023,1,9,14,0),
                    LocalDateTime.of(2023,1,10,18,0));

            Lecture lecture8 = new Lecture("dog","컴퓨터공학","통계학", 5, 3, "화요일", LocalTime.of(10,0),LocalTime.of(13,0), LocalDateTime.of(2023,1,11,14,0),
                    LocalDateTime.of(2023,1,11,18,0),LocalDateTime.of(2023,1,9,14,0),
                    LocalDateTime.of(2023,1,10,18,0));

            Lecture lecture9 = new Lecture("cat","컴퓨터공학","네트워크", 5, 3, "화요일", LocalTime.of(10,0),LocalTime.of(13,0), LocalDateTime.of(2023,1,11,14,0),
                    LocalDateTime.of(2023,1,11,18,0),LocalDateTime.of(2023,1,9,14,0),
                    LocalDateTime.of(2023,1,10,18,0));

            Lecture lecture10 = new Lecture("bird","컴퓨터공학","AWS", 5, 3, "화요일", LocalTime.of(10,0),LocalTime.of(13,0), LocalDateTime.of(2023,1,11,14,0),
                    LocalDateTime.of(2023,1,11,18,0),LocalDateTime.of(2023,1,9,14,0),
                    LocalDateTime.of(2023,1,10,18,0));

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

        }

    }

}
