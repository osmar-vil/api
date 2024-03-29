package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.domain.consulta.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private CreateConsultaService service;

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private CancelConsultaService cancelConsultaService;

    @PostMapping
    @Transactional
    public ResponseEntity<ConsultaResponse> create (@RequestBody @Valid ConsultaRequest request) {
        var response = service.create(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<ConsultaResponseList>> list(Pageable pageable) {
        var response = repository.findAll(pageable).map(ConsultaResponseList::new);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<?> cancel (@RequestBody @Valid CancelConsultaRequest request) {
        cancelConsultaService.cancel(request);
        return ResponseEntity.noContent().build();
    }
}
