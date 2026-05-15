package cards;

public class InsufficientManaException extends Exception {
    public InsufficientManaException(String message) {
        super(message);
    }
}
