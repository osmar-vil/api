package med.voll.api.domain.consulta.validation;

import med.voll.api.domain.ValidationError;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.medico.MedicoRepository;

import java.time.LocalDateTime;

public class ValidateDoctorAgenda {

    private ConsultaRepository repository;

    public void validate (Long doctorId, LocalDateTime date) {
        var isHaveOtherAppointment = repository.existsByMedicoIdAndDate(doctorId, date);
        if (isHaveOtherAppointment) throw new ValidationError("This Doctor have an appointment for this time already");
    }

}
