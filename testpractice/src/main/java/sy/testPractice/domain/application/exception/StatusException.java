package sy.testPractice.domain.application.exception;

public class StatusException extends RuntimeException {

    public StatusException() {
    }

    public StatusException(String message) {
        super(message);
    }
}
