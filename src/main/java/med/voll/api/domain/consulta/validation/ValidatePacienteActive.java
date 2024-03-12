package med.voll.api.domain.consulta.validation;

import med.voll.api.domain.ValidationError;
import med.voll.api.domain.paciente.PacienteRepository;

public class ValidatePacienteActive {

    private PacienteRepository repository;

    public void validate (Long pacienteId) {
        var isActive = repository.isActiveById(pacienteId);
        if (!isActive) throw new ValidationError("This Paciente is inactive so can made any Appointment");
    }

}
