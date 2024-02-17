package med.voll.api.controller;

import med.voll.api.dto.doctor.DoctorCreateRequest;
import med.voll.api.entity.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void create(@RequestBody DoctorCreateRequest request) {
        repository.save(new Medico(request));
    }
}
