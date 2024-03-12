package med.voll.api.domain.consulta.validation;

import med.voll.api.domain.ValidationError;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidateConcultAntecedence {

    public void validate (LocalDateTime dateTime) {
        var minutesDifference = Duration.between(LocalDateTime.now(), dateTime).toMinutes();
        if (minutesDifference <= 30) throw new ValidationError("Booking only can be did 30 minutes after");
    }

}
