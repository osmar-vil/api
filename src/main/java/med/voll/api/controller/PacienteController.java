package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.paciente.PacienteCreateRequest;
import med.voll.api.dto.paciente.PacienteResponse;
import med.voll.api.dto.paciente.PacienteResponseList;
import med.voll.api.entity.Paciente;
import med.voll.api.repository.PacienteRepository;
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
        var response = repository.findAll(pageable).map(PacienteResponseList::new);
        return ResponseEntity.ok(response);
    }
}
