package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.authentication.AuthResponse;
import med.voll.api.domain.authentication.LoginRequest;
import med.voll.api.domain.user.User;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest request) {
        var authToken = new UsernamePasswordAuthenticationToken(request.login(), request.password());
        var authentication = manager.authenticate(authToken);
        var tokenJwt = tokenService.generateToken( (User) authentication.getPrincipal());

        return ResponseEntity.ok(new AuthResponse(tokenJwt));
    }

}
