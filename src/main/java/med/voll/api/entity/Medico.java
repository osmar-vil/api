package med.voll.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.doctor.DoctorCreateRequest;
import med.voll.api.dto.doctor.Expertise;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Expertise especialidade;
    @Embedded
    private Address endereco;

    public Medico (DoctorCreateRequest request) {
        this.nome = request.nome();
        this.email = request.email();
        this.telefone = request.telefone();
        this.crm = request.crm();
        this.especialidade = request.especialidade();
        this.endereco = new Address(request.address());
    }
}
