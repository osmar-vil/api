package med.voll.api.domain.authentication;

public record LoginRequest(
        String login,
        String password
) {
}
