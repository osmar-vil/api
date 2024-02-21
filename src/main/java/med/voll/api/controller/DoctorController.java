package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.doctor.DoctorCreateRequest;
import med.voll.api.dto.doctor.DoctorResponse;
import med.voll.api.entity.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void create(@RequestBody @Valid DoctorCreateRequest request) {
        repository.save(new Medico(request));
    }

    @GetMapping
    public Page <DoctorResponse> list (Pageable pageable) {
         return repository.findAll(pageable).map(DoctorResponse::new);
    }
}
