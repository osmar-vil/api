package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> notFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> badRequest(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ValidationErrors::new ).toList());
    }

    private record ValidationErrors( String campo, String menssagem ) {
        public ValidationErrors (FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
