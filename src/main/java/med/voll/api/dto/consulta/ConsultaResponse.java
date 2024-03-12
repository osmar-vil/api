package med.voll.api.dto.consulta;

import java.time.LocalDateTime;

public record ConsultaResponse(Long id, Long medico_id, Long paciente_id, LocalDateTime data) {
}
