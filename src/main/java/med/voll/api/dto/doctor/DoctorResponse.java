package med.voll.api.dto.doctor;

import med.voll.api.entity.Address;
import med.voll.api.entity.Medico;

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