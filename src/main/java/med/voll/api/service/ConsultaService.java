package med.voll.api.service;

import med.voll.api.dto.consulta.ConsultaRequest;
import med.voll.api.entity.Consulta;
import med.voll.api.entity.Medico;
import med.voll.api.entity.Paciente;
import med.voll.api.exceptions.ValidationError;
import med.voll.api.repository.ConsultaRepository;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public void create (ConsultaRequest request) {
        if (!pacienteRepository.existsById(request.pacienteId()))
            throw new ValidationError("Patient ID does not exist");

        if (request.medicoId() != null && !medicoRepository.existsById(request.medicoId()))
            throw new ValidationError("Doctor does not exist with that ID");

        var paciente = pacienteRepository.getReferenceById(request.pacienteId());
        var medico = selectDoctor(request);
        var consulta = new Consulta(null, medico, paciente, request.datetime());

        consultaRepository.save(consulta);
    }

    private Medico selectDoctor(ConsultaRequest request) {
        if (request.medicoId() != null) return medicoRepository.getReferenceById(request.medicoId());

        if (request.especialidade() == null)
            throw new ValidationError("especialidade it's required when doctor is not selected");

        return medicoRepository.findAleatoryFreeTime(request.especialidade(), request.datetime());
    }

}
