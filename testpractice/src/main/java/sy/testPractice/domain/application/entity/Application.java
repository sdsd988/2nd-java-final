package sy.testPractice.domain.application.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sy.testPractice.domain.common.entity.BaseEntity;
import sy.testPractice.domain.lecture.entity.Lecture;
import sy.testPractice.domain.member.entity.Member;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Application extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lecture;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;




    public Application(Member member, Lecture lecture, ApplicationStatus status) {
        this.member = member;
        this.lecture = lecture;
        this.status = status;
    }


    public void updateStatus(ApplicationStatus status) {
        this.status = status;
    }
}
