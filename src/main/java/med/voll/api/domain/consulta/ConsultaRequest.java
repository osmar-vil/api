package med.voll.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Expertise;

import java.time.LocalDateTime;

public record ConsultaRequest(
        @NotNull
        @Min(1)
        @JsonAlias("paciente_id")
        Long pacienteId,

        @JsonAlias("medico_id")
        Long medicoId,

        @NotNull
        @Future
        LocalDateTime datetime,


        Expertise especialidade) {
}
