package med.voll.api.domain.consulta.validation;

import med.voll.api.domain.ValidationError;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class WorkHourClinic {

    public void valid (LocalDateTime date) {
        var isSunday = date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var isAfterClinicOpened = date.getHour() < 7;
        var isBeforeClinicClosed = date.getHour() > 18;

        if (isSunday || isAfterClinicOpened || isBeforeClinicClosed)
            throw new ValidationError("the clinic does not work in this time");
    }

}
