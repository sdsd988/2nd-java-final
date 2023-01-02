package sy.testPractice.domain.application.exception;

import sy.testPractice.domain.common.exception.NotFoundException;

public class ApplicationNotFoundException extends NotFoundException {
    public ApplicationNotFoundException() {super("존재하지 않는 지원서입니다.");}
}
