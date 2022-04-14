package br.com.leords.forum.configuration.security;

import br.com.leords.forum.models.User;
import br.com.leords.forum.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("E-mail or password incorrect!");
    }
    
}
