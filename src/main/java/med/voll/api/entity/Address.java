package med.voll.api.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.address.AddressCreateRequest;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Address (AddressCreateRequest request) {
        this.logradouro = request.logradouro();
        this.bairro = request.bairro();
        this.cep = request.cep();
        this.numero = request.numero();
        this.complemento = request.complemento();
        this.cidade = request.cidade();
        this.uf = request.uf();
    }
}
