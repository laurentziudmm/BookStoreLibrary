package backend.exception;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1625655582493369826L;

    public BaseException(String message) {
        super(message);
    }
}
