package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.domain.paciente.PacienteCreateRequest;
import med.voll.api.domain.paciente.PacienteResponse;
import med.voll.api.domain.paciente.PacienteResponseList;
import med.voll.api.domain.paciente.PacienteUpdateRequest;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<PacienteResponse> create (@RequestBody @Valid PacienteCreateRequest request, UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(request);
        repository.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new PacienteResponse(paciente));
    }

    @GetMapping()
    public ResponseEntity<Page<PacienteResponseList>> list (@PageableDefault(sort = {"nome"}) Pageable pageable) {
        var response = repository.findAllByAtivoTrue(pageable).map(PacienteResponseList::new);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> get (@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new PacienteResponse(paciente));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteResponse> update (@RequestBody @Valid PacienteUpdateRequest request, @PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.update(request);
        return ResponseEntity.ok(new PacienteResponse(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.softDelete();
        return ResponseEntity.noContent().build();
    }
}
