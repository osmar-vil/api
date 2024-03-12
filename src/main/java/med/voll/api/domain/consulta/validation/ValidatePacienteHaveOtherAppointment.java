package med.voll.api.domain.consulta.validation;

import med.voll.api.domain.ValidationError;
import med.voll.api.domain.consulta.ConsultaRepository;

import java.time.LocalDateTime;

public class ValidatePacienteHaveOtherAppointment {

    private ConsultaRepository repository;

    public void validate (Long pacienteId, LocalDateTime date) {
        var openedHour = date.withHour(7);
        var closedHour = date.withHour(18);
        var haveOtherAppointment = repository.existsByPacienteIdAndDateBetwen(pacienteId, openedHour, closedHour);
        if (haveOtherAppointment) throw new ValidationError("This paciente already have an appointment today");
    }

}
