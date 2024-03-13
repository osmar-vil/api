package med.voll.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record CancelConsultaRequest(
        @NotNull
        CancelConsultaMotive motive,

        @JsonAlias("other_motive")
        String otherMotive
) {
}
