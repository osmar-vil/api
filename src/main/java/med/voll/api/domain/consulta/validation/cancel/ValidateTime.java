package med.voll.api.domain.consulta.validation.cancel;

import med.voll.api.domain.ValidationError;
import med.voll.api.domain.consulta.CancelConsultaRequest;
import med.voll.api.domain.consulta.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidateTime implements CancelValidation {

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validate(CancelConsultaRequest request) {
        var consult = repository.getReferenceById(request.id());
        var hoursForBooking = Duration.between(LocalDateTime.now(), consult.getData()).toHours();
        if (hoursForBooking < 24) throw new ValidationError("Booking can only cancel 24 hours after");
    }
}
