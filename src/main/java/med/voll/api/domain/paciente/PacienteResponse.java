package med.voll.api.domain.paciente;

import med.voll.api.domain.address.AddressResponse;
import med.voll.api.domain.paciente.Paciente;

public record PacienteResponse(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        AddressResponse endereco
) {
    public PacienteResponse(Paciente paciente) {
        this(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getCpf(),
                new AddressResponse(paciente.getEndereco())
        );
    }
}
