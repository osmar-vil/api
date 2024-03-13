package med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Boolean existsByMedicoIdAndData(Long doctorId, LocalDateTime date);

    @Query("select c from Consulta c where c.paciente.id = :pacienteId and data between :openedHour and :closedHour")
    Consulta existsByPacienteIdAndDateBetwen(Long pacienteId, LocalDateTime openedHour, LocalDateTime closedHour);
}
