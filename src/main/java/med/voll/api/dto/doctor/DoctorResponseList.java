package med.voll.api.dto.doctor;

import med.voll.api.entity.Address;
import med.voll.api.entity.Medico;

public record DoctorResponseList(
    Long id,
    String nome,
    String email,
    String crm,
    Expertise especialidade
) {
    public DoctorResponseList(Medico data) {
        this(data.getId(), data.getNome(), data.getEmail(), data.getCrm(), data.getEspecialidade());
    }
}
