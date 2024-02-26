package med.voll.api.dto.doctor;

import med.voll.api.entity.Medico;

public record DoctorResponse(
    Long id,
    String nome,
    String email,
    String crm,
    Expertise especialidade
) {
    public DoctorResponse(Medico data) {
        this(data.getId(), data.getNome(), data.getEmail(), data.getCrm(), data.getEspecialidade());
    }
}
