package med.voll.api.domain.consulta.validation;

import med.voll.api.domain.ValidationError;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.ConsultaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidateDoctorAgenda implements ValidateConsultant {

    @Autowired
    private ConsultaRepository repository;

    public void validate (ConsultaRequest request) {
        var isHaveOtherAppointment = repository.existsByMedicoIdAndData(request.medicoId(), request.datetime());
        if (isHaveOtherAppointment) throw new ValidationError("This Doctor have an appointment for this time already");
    }

}
