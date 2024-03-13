package med.voll.api.domain.consulta.validation;

import med.voll.api.domain.ValidationError;
import med.voll.api.domain.consulta.ConsultaRequest;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class WorkHourClinic implements ValidateConsultant {

    public void validate (ConsultaRequest request) {
        var isSunday = request.datetime().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var isAfterClinicOpened = request.datetime().getHour() < 7;
        var isBeforeClinicClosed = request.datetime().getHour() > 18;

        if (isSunday || isAfterClinicOpened || isBeforeClinicClosed)
            throw new ValidationError("the clinic does not work in this time");
    }

}
