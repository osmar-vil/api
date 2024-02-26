package med.voll.api.dto.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.address.AddressCreateRequest;

public record DoctorUpdateRequest(
        @NotNull
        Long id,
        String nome,
        String telefone,

        AddressCreateRequest endereco
) {
}
