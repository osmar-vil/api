package med.voll.api.dto.address;

public record AddressCreateRequest(
    String logradouro,
    String bairro,
    String cep,
    String cidade,
    String uf,
    String complemento,
    String numero
) {
}
