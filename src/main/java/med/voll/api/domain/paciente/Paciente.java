package med.voll.api.domain.paciente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Address endereco;
    private boolean ativo;

    public Paciente (PacienteCreateRequest request) {
        nome = request.nome();
        email = request.email();
        telefone = request.telefone();
        cpf = request.cpf();
        endereco = new Address(request.endereco());
        ativo = true;
    }

    public void update (PacienteUpdateRequest request) {
        if (request.nome() != null) this.nome = request.nome();
        if (request.telefone() != null) this.telefone = request.telefone();
        if (request.endereco() != null) this.endereco.update(request.endereco());
    }

    public void softDelete() { this.ativo = false; }
}
