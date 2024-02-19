package med.voll.api.dto.doctor;

import med.voll.api.dto.address.AddressCreateRequest;

public record DoctorCreateRequest(
    String nome,
    String email,
    String crm,
    Expertise especialidade,
    AddressCreateRequest address
) {
}
