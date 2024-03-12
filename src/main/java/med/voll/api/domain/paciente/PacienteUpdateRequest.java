package med.voll.api.domain.paciente;

import med.voll.api.domain.address.AddressCreateRequest;

public record PacienteUpdateRequest(
        String nome,
        String telefone,
        AddressCreateRequest endereco

) {
}
