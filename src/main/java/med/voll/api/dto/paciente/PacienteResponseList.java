package med.voll.api.dto.paciente;

import med.voll.api.entity.Paciente;

public record PacienteResponseList(
        Long id,
        String nome,
        String email,
        String cpf
) {
    public PacienteResponseList(Paciente paciente) {
        this(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf()
        );
    }
}
