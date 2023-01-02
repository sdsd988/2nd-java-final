package sy.testPractice.domain.member.exception;


import sy.testPractice.domain.common.exception.NotFoundException;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException() {
        super("회원을 찾을 수 없습니다.");
    }
}
