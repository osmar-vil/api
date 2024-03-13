package med.voll.api.domain.consulta.validation.cancel;

import med.voll.api.domain.ValidationError;
import med.voll.api.domain.consulta.CancelConsultaMotive;
import med.voll.api.domain.consulta.CancelConsultaRequest;

public class ValiteMotive implements CancelValidation {

    public void validate(CancelConsultaRequest request) {
        if (request.motive() == CancelConsultaMotive.OUTROS && request.otherMotive() == null)
            throw new ValidationError("Please you have to define your other motive in the field other_motive");
    }
}
