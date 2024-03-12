package med.voll.api.domain.paciente;

import med.voll.api.domain.paciente.Paciente;

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
