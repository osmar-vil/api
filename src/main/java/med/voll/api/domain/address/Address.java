package med.voll.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public void update(AddressCreateRequest request) {
        if (request.logradouro() != null) this.logradouro = request.logradouro();
        if (request.bairro() != null) this.bairro = request.bairro();
        if (request.cep() != null) this.cep = request.cep();
        if (request.numero() != null) this.numero = request.numero();
        if (request.complemento() != null) this.complemento = request.complemento();
        if (request.cidade() != null) this.cidade = request.cidade();
        if (request.uf() != null) this.uf = request.uf();
    }
}
