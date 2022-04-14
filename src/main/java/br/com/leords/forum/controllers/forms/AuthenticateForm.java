package br.com.leords.forum.controllers.forms;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticateForm {
    
    private String email;
    private String password;
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public UsernamePasswordAuthenticationToken formToUsernamePasswordAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
