package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Boolean existsByMedicoIdAndDate(Long doctorId, LocalDateTime date);

    @Query("select true from Consulta c where c.paciente.id = :pacienteId and data between :openedHour and :closedHour")
    Boolean existsByPacienteIdAndDateBetwen(Long pacienteId, LocalDateTime openedHour, LocalDateTime closedHour);
}
