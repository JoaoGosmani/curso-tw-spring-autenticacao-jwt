package br.com.joaogosmani.javajobs.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.joaogosmani.javajobs.dtos.UserDTO;
import br.com.joaogosmani.javajobs.models.User;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User toModel(UserDTO userDTO) {
        User user = new User();

        user.setUsername(userDTO.getUsername());

        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(hashedPassword);

        return user;
    }

}
