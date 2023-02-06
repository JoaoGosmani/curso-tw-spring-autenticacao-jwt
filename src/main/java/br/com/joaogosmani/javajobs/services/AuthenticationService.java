package br.com.joaogosmani.javajobs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.joaogosmani.javajobs.auth.AuthenticatedUser;
import br.com.joaogosmani.javajobs.dtos.JwtResponse;
import br.com.joaogosmani.javajobs.dtos.UserDTO;
import br.com.joaogosmani.javajobs.models.User;
import br.com.joaogosmani.javajobs.repositories.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username %s not found", username)));

        return new AuthenticatedUser(foundUser);
    }

    public JwtResponse createJwtResponse(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticateUser = authenticationManager.authenticate(authentication);

        // TODO
        return null;
    }
    
}
