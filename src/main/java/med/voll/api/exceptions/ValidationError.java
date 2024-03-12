package med.voll.api.exceptions;

public class ValidationError extends RuntimeException {
    public ValidationError(String message) {
        super(message);
    }
}
