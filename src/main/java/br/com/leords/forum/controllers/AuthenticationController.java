package br.com.leords.forum.controllers;

import br.com.leords.forum.configuration.security.TokenService;
import br.com.leords.forum.controllers.forms.AuthenticateForm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sessions")
public class AuthenticationController {
    
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    
    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }
    
    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Valid AuthenticateForm form) {
        UsernamePasswordAuthenticationToken userData = form.formToUsernamePasswordAuthenticationToken();
        try {
            Authentication authenticate = authenticationManager.authenticate(userData);
            String token = tokenService.generateToken(authenticate);
            System.out.println(token);
            return ResponseEntity.ok().build();
        } catch (AuthenticationException error) {
            return ResponseEntity.badRequest().build();
        }
    }
}
