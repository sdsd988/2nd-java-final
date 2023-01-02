package sy.testPractice.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sy.testPractice.domain.application.entity.Application;
import sy.testPractice.domain.application.entity.ApplicationStatus;
import sy.testPractice.domain.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String memberName;

    private String memberInfo;

    private String memberNum;

    private int maxScore;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @JsonManagedReference
    @OneToMany(mappedBy = "member")
    private List<Application> applications = new ArrayList<>();

    public Member(String email, String password, String memberName, String memberInfo, String memberNum,int maxScore, MemberRole role) {
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.memberInfo = memberInfo;
        this.memberNum = memberNum;
        this.maxScore = maxScore;
        this.role = role;
    }


}
