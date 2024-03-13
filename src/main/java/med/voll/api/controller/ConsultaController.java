package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.consulta.ConsultaResponse;
import med.voll.api.domain.consulta.ConsultaRequest;
import med.voll.api.domain.consulta.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping
    public ResponseEntity<?> create (@RequestBody @Valid ConsultaRequest request) {
        service.create(request);
        var Response = new ConsultaResponse(null, null, null, null);
        return ResponseEntity.ok(Response);
    }

}
