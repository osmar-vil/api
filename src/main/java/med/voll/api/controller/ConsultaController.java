package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.consulta.ConsultaResponse;
import med.voll.api.domain.consulta.ConsultaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @PostMapping
    public ResponseEntity<?> create (@RequestBody @Valid ConsultaRequest request) {
        System.out.println(request);
        var Response = new ConsultaResponse(null, null, null, null);
        return ResponseEntity.ok(Response);
    }

}
