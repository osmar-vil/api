package med.voll.api.domain.consulta.validation;

import med.voll.api.domain.ValidationError;
import med.voll.api.domain.medico.MedicoRepository;

public class ValidDoctorIsActive {

    private MedicoRepository repository;

    public void validate (Long doctorId) {
        var isActive = repository.findActiveById(doctorId);
        if (!isActive) throw new ValidationError("Can not be made any booking with an inactive doctor");
    }

}
