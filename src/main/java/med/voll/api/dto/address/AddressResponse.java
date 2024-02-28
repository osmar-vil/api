package med.voll.api.dto.address;

import med.voll.api.entity.Address;

public record AddressResponse(
        String logradouro,
        String bairro,
        String cep,
        String numero,
        String complemento,
        String cidade,
        String uf
) {
    public AddressResponse (Address address) {
        this(
                address.getLogradouro(),
                address.getBairro(),
                address.getCep(),
                address.getNumero(),
                address.getComplemento(),
                address.getCidade(),
                address.getUf()
        );
    }
}
