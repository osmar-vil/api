package med.voll.api.domain.consulta.validation.create;

import med.voll.api.domain.ValidationError;
import med.voll.api.domain.consulta.ConsultaRequest;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidDoctorIsActive implements ValidateConsultant {

    @Autowired
    private MedicoRepository repository;

    public void validate (ConsultaRequest request) {
        var isActive = repository.findActiveById(request.medicoId());
        if (!isActive) throw new ValidationError("Can not be made any booking with an inactive doctor");
    }

}
