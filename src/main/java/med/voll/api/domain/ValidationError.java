package med.voll.api.domain;

public class ValidationError extends RuntimeException {
    public ValidationError(String message) {
        super(message);
    }
}
