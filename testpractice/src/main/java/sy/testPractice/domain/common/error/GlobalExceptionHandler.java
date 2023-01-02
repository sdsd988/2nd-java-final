package sy.testPractice.domain.common.error;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import sy.testPractice.domain.common.exception.ForbiddenException;
import sy.testPractice.domain.common.exception.NotFoundException;
import sy.testPractice.domain.lecture.entity.Lecture;
import sy.testPractice.domain.lecture.exception.LectureNotFoundException;
import sy.testPractice.domain.member.exception.AlreadyExistsEmailException;
import sy.testPractice.domain.member.exception.MemberNotFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    protected DefaultErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new DefaultErrorResult(400, "Validation Error!");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    protected DefaultErrorResult MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        return new DefaultErrorResult(400, "TypeMismatch Error!");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    protected DefaultErrorResult handleNotFoundException(MemberNotFoundException e){
        return new DefaultErrorResult(404, "Member NotFound Error!");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    protected DefaultErrorResult handleNotFoundException(LectureNotFoundException e){
        return new DefaultErrorResult(404, "Lecture NotFound Error!");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    protected DefaultErrorResult handleAlreadyExistsEmailException(AlreadyExistsEmailException e){
        return new DefaultErrorResult(400, "AlreadyExistsEmail Error!");
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler
    protected DefaultErrorResult handleForbiddenException(ForbiddenException e){
        return new DefaultErrorResult(403, "Forbidden Error!");
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    protected DefaultErrorResult handleNotFoundException(NotFoundException e){
        return new DefaultErrorResult(404, "NotFound Error!");
    }


    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler
    protected DefaultErrorResult handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return new DefaultErrorResult(405, "HttpMethod Error!");
    }




}
