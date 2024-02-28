package med.voll.api.dto.paciente;

import med.voll.api.dto.address.AddressResponse;
import med.voll.api.entity.Paciente;

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
