package med.voll.api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.paciente.PacienteCreateRequest;

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
}
