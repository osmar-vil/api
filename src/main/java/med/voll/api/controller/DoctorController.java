package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.doctor.DoctorCreateRequest;
import med.voll.api.dto.doctor.DoctorResponse;
import med.voll.api.dto.doctor.DoctorUpdateRequest;
import med.voll.api.entity.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DoctorCreateRequest request) {
        repository.save(new Medico(request));
    }

    @GetMapping
    public Page<DoctorResponse> list (@PageableDefault(sort = {"nome"}) Pageable pageable) {
         return repository.findAllByAtivoTrue(pageable).map(DoctorResponse::new);
    }

    @PutMapping
    @Transactional
    public void update (@RequestBody @Valid DoctorUpdateRequest request) {
        var medico = repository.getReferenceById(request.id());
        medico.update(request);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete (@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.exclude();
    }
}
