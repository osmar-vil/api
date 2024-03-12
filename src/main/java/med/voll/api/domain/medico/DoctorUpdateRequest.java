package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.AddressCreateRequest;

public record DoctorUpdateRequest(
        @NotNull
        Long id,
        String nome,
        String telefone,

        AddressCreateRequest endereco
) {
}
