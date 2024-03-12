package med.voll.api.domain.medico;

import med.voll.api.domain.address.Address;

public record DoctorResponse(
        Long id,
        String nome,
        String email,
        String crm,
        String telefone,
        Expertise especialidade,
        Address endereco
) {
    public DoctorResponse (Medico medico) {
        this(
            medico.getId(),
            medico.getNome(),
            medico.getEmail(),
            medico.getCrm(),
            medico.getTelefone(),
            medico.getEspecialidade(),
            medico.getEndereco()
        );
    }
}