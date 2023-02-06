package br.com.joaogosmani.javajobs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaogosmani.javajobs.dtos.UserDTO;
import br.com.joaogosmani.javajobs.mappers.UserMapper;
import br.com.joaogosmani.javajobs.models.User;
import br.com.joaogosmani.javajobs.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User create(UserDTO userDTO) {
        User userToCreate = userMapper.toModel(userDTO);

        return userRepository.save(userToCreate);
    } 

}
