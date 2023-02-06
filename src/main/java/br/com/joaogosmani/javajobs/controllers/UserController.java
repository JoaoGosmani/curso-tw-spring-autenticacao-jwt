package br.com.joaogosmani.javajobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaogosmani.javajobs.dtos.UserDTO;
import br.com.joaogosmani.javajobs.models.User;
import br.com.joaogosmani.javajobs.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User create(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    } 

}