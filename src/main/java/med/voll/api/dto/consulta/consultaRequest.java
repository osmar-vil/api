package med.voll.api.dto.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record consultaRequest(
    @NotNull
    @Min(1)
    Long paciente_id,
    Long medico_id,
    @NotNull
    @Future
    LocalDateTime datetime) {
}
