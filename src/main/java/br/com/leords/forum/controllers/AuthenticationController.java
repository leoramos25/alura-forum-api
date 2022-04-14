package br.com.leords.forum.controllers;

import br.com.leords.forum.controllers.forms.AuthenticateForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sessions")
public class AuthenticationController {
    
    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Valid AuthenticateForm form) {
        System.out.println(form.getEmail() + " " + form.getPassword());
        return ResponseEntity.ok().build();
    }
}
