package med.voll.api.repository;

import med.voll.api.dto.doctor.Expertise;
import med.voll.api.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable pageable);

    @Query("""
            select m from Medico m
            where m.ativo = true
                and m.especialidade = :especialidade
                and m.id not in( select c.medico.id from Consulta c where c.data = :datatime )
            order by rand()
            limit 1
            """)
    Medico findAleatoryFreeTime(Expertise especialidade, LocalDateTime datatime);
}
