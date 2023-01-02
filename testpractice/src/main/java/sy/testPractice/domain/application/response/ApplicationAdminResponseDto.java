package sy.testPractice.domain.application.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sy.testPractice.domain.application.entity.Application;
import sy.testPractice.domain.application.entity.ApplicationStatus;

@NoArgsConstructor
@Getter
@Setter
public class ApplicationAdminResponseDto {

    private String lecture;
    private String memberName;
    private ApplicationStatus status;


    public ApplicationAdminResponseDto(Application application) {
        this.lecture = application.getLecture().getLectureName();
        this.memberName = application.getMember().getMemberName();
        this.status = application.getStatus();

    }
}
