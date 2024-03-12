package med.voll.api.dto;

import java.util.Date;

public record consultaRequest(Long paciente_id, Long medico_id, Date datetime) {
}
