package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record ConsultaResponseList(
        Long id,
        Long medico_id,
        Long paciente_id,
        LocalDateTime data
) {

    public ConsultaResponseList(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }

}
