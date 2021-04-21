package backend.exception;

public class BookedRoomException extends BaseException {
    private static final long serialVersionUID = -5321283992214296450L;

    public BookedRoomException(String message) {
        super(message);
    }
}
