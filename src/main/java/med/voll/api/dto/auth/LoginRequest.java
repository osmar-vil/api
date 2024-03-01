package med.voll.api.dto.auth;

public record LoginRequest(
        String login,
        String password
) {
}
