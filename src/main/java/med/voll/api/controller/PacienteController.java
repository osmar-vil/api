package med.voll.api.controller;

import med.voll.api.dto.paciente.PacienteCreateRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @PostMapping
    public void create (@RequestBody PacienteCreateRequest request) {
        System.out.println(request);
    }
}
