package med.voll.api.domain.consulta.validation.cancel;

import med.voll.api.domain.consulta.CancelConsultaRequest;

public interface CancelValidation {
    void validate(CancelConsultaRequest request);
}
