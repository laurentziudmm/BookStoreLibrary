package backend.exception;

public class ResourceNotFoundException extends BaseException {
    private static final long serialVersionUID = -6525748879063555329L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
