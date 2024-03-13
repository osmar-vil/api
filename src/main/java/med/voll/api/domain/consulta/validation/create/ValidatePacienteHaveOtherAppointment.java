package med.voll.api.domain.consulta.validation.create;

import med.voll.api.domain.ValidationError;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.ConsultaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatePacienteHaveOtherAppointment implements ValidateConsultant {

    @Autowired
    private ConsultaRepository repository;

    public void validate (ConsultaRequest request) {
        var openedHour = request.datetime().withHour(7);
        var closedHour = request.datetime().withHour(18);
        var haveOtherAppointment = repository.existsByPacienteIdAndDateBetwen(request.pacienteId(), openedHour, closedHour);
        if (haveOtherAppointment != null) throw new ValidationError("This paciente already have an appointment today");
    }

}
