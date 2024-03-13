package med.voll.api.domain.consulta;

import med.voll.api.domain.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public void cancel (Long id, CancelConsultaRequest request) {
        if (request.motive() == CancelConsultaMotive.OUTROS && request.otherMotive() == null)
            throw new ValidationError("Please you have to define your other motive in the field other_motive");
    }

}
