package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import med.voll.api.entity.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    public String generateToken (User user) {
        try {
            var algorithm = Algorithm.HMAC256("12345678");
            return JWT.create()
                    .withIssuer("API Voll.med")
                    .withSubject(user.getLogin())
                    .withClaim("id", user.getId())
                    .withExpiresAt(ExpiredAt())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Something get wrong when generate the JWT Token", exception);
        }
    }

    private Instant ExpiredAt() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-02:00"));
    }

}
