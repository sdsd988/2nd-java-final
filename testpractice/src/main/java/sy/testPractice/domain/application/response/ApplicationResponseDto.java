package sy.testPractice.domain.application.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sy.testPractice.domain.application.entity.Application;
import sy.testPractice.domain.application.entity.ApplicationStatus;

@NoArgsConstructor
@Getter
@Setter
public class ApplicationResponseDto {

    private String name;
    private String email;
    private String phoneNum;
    private String status;
    private String motivation;
    private String afterWork;

    public ApplicationResponseDto(String name, String email, String phoneNum, String status, String motivation, String afterWork) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.status = status;
        this.motivation = motivation;
        this.afterWork = afterWork;
    }
}
