package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validation.create.ValidateConsultant;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.ValidationError;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private List<ValidateConsultant> validations;

    public ConsultaResponse create (ConsultaRequest request) {
        if (!pacienteRepository.existsById(request.pacienteId()))
            throw new ValidationError("Patient ID does not exist");

        if (request.medicoId() != null && !medicoRepository.existsById(request.medicoId()))
            throw new ValidationError("Doctor does not exist with that ID");

        validations.forEach(v -> v.validate(request));

        var paciente = pacienteRepository.getReferenceById(request.pacienteId());
        var medico = selectDoctor(request);
        var consulta = new Consulta(null, medico, paciente, request.datetime(), false, null);

        consultaRepository.save(consulta);

        return new ConsultaResponse(consulta);
    }

    private Medico selectDoctor(ConsultaRequest request) {
        if (request.medicoId() != null) return medicoRepository.getReferenceById(request.medicoId());

        if (request.especialidade() == null)
            throw new ValidationError("especialidade it's required when doctor is not selected");

        return medicoRepository.findAleatoryFreeTime(request.especialidade(), request.datetime());
    }

}
