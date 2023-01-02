//package sy.testPractice.domain.application.response;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import sy.testPractice.domain.application.entity.Application;
//import sy.testPractice.domain.application.entity.ApplicationStatus;
//
//@NoArgsConstructor
//@Getter
//@Setter
//public class ApplicationAdminSearchResponseDto {
//
//    private String lecture;
//    private ApplicationStatus status;
//    private String motivation;
//    private String afterWish;
//
//    public ApplicationAdminSearchResponseDto(Application application) {
//        this.lecture = application.getLecture().getLectureName();
//        this.status = application.getStatus();
//        this.motivation = application.getMotivation();
//        this.afterWish = application.getAfterWish();
//    }
//}
