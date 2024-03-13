package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validation.cancel.CancelValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancelConsultaService {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private List<CancelValidation> validations;

    public void cancel (CancelConsultaRequest request) {
        validations.forEach(v -> v.validate(request));
    }

}
