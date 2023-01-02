package sy.testPractice.domain.application.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sy.testPractice.domain.application.entity.ApplicationStatus;

@NoArgsConstructor
@Getter
@Setter
public class ApplicationSaveRequestDto {

    private String lectureName;
    private String applicationStatus;

    @Builder
    public ApplicationSaveRequestDto(String lectureName, String memberName, String applicationStatus) {
        this.lectureName = lectureName;
        this.applicationStatus = applicationStatus;
    }
}
