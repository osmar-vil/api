package med.voll.api.domain.consulta.validation;

import med.voll.api.domain.ValidationError;
import med.voll.api.domain.consulta.ConsultaRequest;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatePacienteActive implements ValidateConsultant {

    @Autowired
    private PacienteRepository repository;

    public void validate (ConsultaRequest request) {
        var isActive = repository.isActiveById(request.pacienteId());
        if (!isActive) throw new ValidationError("This Paciente is inactive so can made any Appointment");
    }

}
