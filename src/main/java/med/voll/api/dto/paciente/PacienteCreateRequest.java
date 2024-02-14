package med.voll.api.dto.paciente;

import med.voll.api.dto.address.AddressCreateRequest;

public record PacienteCreateRequest(
    String nome,
    String email,
    String telefone,
    String cpf,
    AddressCreateRequest address
) {
}
