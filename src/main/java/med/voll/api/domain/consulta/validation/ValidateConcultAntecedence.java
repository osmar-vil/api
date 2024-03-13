package med.voll.api.domain.consulta.validation;

import med.voll.api.domain.ValidationError;
import med.voll.api.domain.consulta.ConsultaRequest;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidateConcultAntecedence implements ValidateConsultant {

    public void validate (ConsultaRequest request) {
        var dateTime = request.datetime();
        var minutesDifference = Duration.between(LocalDateTime.now(), dateTime).toMinutes();
        if (minutesDifference <= 30) throw new ValidationError("Booking only can be did 30 minutes after");
    }
}
