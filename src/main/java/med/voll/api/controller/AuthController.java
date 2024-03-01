package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.auth.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void login(@RequestBody @Valid LoginRequest request) {
        var token = new UsernamePasswordAuthenticationToken(request.login(), request.password());
        var authentication = manager.authenticate(token);
    }

}
