package med.voll.api.dto.paciente;

import med.voll.api.dto.address.AddressCreateRequest;

public record PacienteUpdateRequest(
        String nome,
        String telefone,
        AddressCreateRequest endereco

) {
}
