package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medico.DoctorCreateRequest;
import med.voll.api.domain.medico.DoctorResponse;
import med.voll.api.domain.medico.DoctorResponseList;
import med.voll.api.domain.medico.DoctorUpdateRequest;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DoctorResponse> create(@RequestBody @Valid DoctorCreateRequest request, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(request);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DoctorResponse(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorResponseList>> list (@PageableDefault(sort = {"nome"}) Pageable pageable) {
         var response = repository.findAllByAtivoTrue(pageable).map(DoctorResponseList::new);
         return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> get (@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DoctorResponse(medico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DoctorResponse> update (@RequestBody @Valid DoctorUpdateRequest request) {
        var medico = repository.getReferenceById(request.id());
        medico.update(request);
        return ResponseEntity.ok(new DoctorResponse(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete (@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.softDelete();
        return ResponseEntity.noContent().build();
    }
}
