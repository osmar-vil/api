package med.voll.api.domain.medico;

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
