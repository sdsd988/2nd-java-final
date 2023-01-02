package sy.testPractice.domain.common.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sy.testPractice.domain.application.service.ApplicationService;

@RequiredArgsConstructor
@Component
public class Scheduler {

    private final ApplicationService applicationService;

    @Scheduled(cron = "0 0 0 * * *")
    public void manageApplication(){
        System.out.println("매일 0시 0분 0초에 실행");
        applicationService.setTimeExpireApplication();
    }

}
