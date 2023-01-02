package sy.testPractice.domain.application.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sy.testPractice.domain.application.request.ApplicationSaveRequestDto;
import sy.testPractice.domain.application.response.ApplicationAdminResponseDto;
import sy.testPractice.domain.application.service.ApplicationService;
import sy.testPractice.domain.common.success.DefaultResult;
import sy.testPractice.domain.common.success.StatusCode;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
@Slf4j
public class ApplicationController {

    private final ApplicationService applicationService;


    /**
     * 사전 수강 신청
     * @param memberId
     * @param applicationSaveRequestDto
     * @return
     */
    @PostMapping("/applications/reserve/{memberId}")
    public ResponseEntity<String> saveApplication(@PathVariable Long memberId,
                                  @RequestBody ApplicationSaveRequestDto applicationSaveRequestDto) {

        int result = applicationService.reserveApplication(memberId, applicationSaveRequestDto);

        if (result == 1) {
            return new ResponseEntity<>("사전 신청 완료, 강의가 신청되었습니다.", HttpStatus.OK);
        } else if(result==2){
            return new ResponseEntity<>("장바구니 기간이 아닙니다.", HttpStatus.BAD_REQUEST);
        } else if(result==3){
            return new ResponseEntity<>("사전 신청 실패, 신청한 강의는 요일/시간이 중복되었습니다.", HttpStatus.BAD_REQUEST);
        } else if(result==4){
            return new ResponseEntity<>("사전 신청 실패, 정원이 초과되었습니다. 찜 상태로 변경됩니다.", HttpStatus.BAD_REQUEST);
        } else if(result==5){
            return new ResponseEntity<>("이미 신청 완료 되어있습니다.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }



    /**
     * 본 수강 신청
     *
     * @param memberId
     * @param applicationSaveRequestDto
     * @return
     */
    @PostMapping("/applications/{memberId}")
    public ResponseEntity<String> submitApplication(@PathVariable Long memberId,
                                                    @RequestBody ApplicationSaveRequestDto applicationSaveRequestDto) {

        int result = applicationService.submitApplication(memberId, applicationSaveRequestDto);

        if (result == 1) {
            return new ResponseEntity<>("수강신청이 되었습니다.", HttpStatus.OK);
        } else if(result==2){
            return new ResponseEntity<>("이미 신청 완료 되어있습니다.", HttpStatus.BAD_REQUEST);
        } else if(result==3){
            return new ResponseEntity<>("수강생 최대 인원 수 초과하였습니다.", HttpStatus.BAD_REQUEST);
        } else if(result==4){
            return new ResponseEntity<>("최대 신청 학점을 초과하였습니다.", HttpStatus.BAD_REQUEST);
        } else if(result==5){
            return new ResponseEntity<>("신청 실패, 신청한 강의는 요일/시간이 중복되었습니다.", HttpStatus.BAD_REQUEST);
        }  else if(result==6){
            return new ResponseEntity<>("신청 실패, 본 수강 신청 기간이 아닙니다.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 지원서 삭제
     *
     * @param applicationId
     * @return
     */
    @DeleteMapping("/applications/{applicationId}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long applicationId) {

        int result = applicationService.removeApplication(applicationId);

        if (result == 1) {
            return new ResponseEntity<>("지원서 삭제 되었습니다.", HttpStatus.OK);
        }

        return new ResponseEntity<>("잘못된 요청입니다.",HttpStatus.OK);
    }

    /**
     * 강의별 지원서 조회 - 교수자
     * @param lectureName
     * @return
     */
    @GetMapping("/applications/lecture/teacher")
    public ResponseEntity getApplicationLectureId(@RequestParam String lectureName) {

        List<ApplicationAdminResponseDto> applications = applicationService.getLectureApplicationByAdmin(lectureName);

        return new ResponseEntity(DefaultResult.res(StatusCode.OK,
                "과목별 지원서 조회 성공 ",applications), HttpStatus.OK);
    }


}


