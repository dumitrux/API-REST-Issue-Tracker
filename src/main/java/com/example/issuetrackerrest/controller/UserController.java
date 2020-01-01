package com.example.issuetrackerrest.controller;


import com.example.issuetrackerrest.entity.User;
import com.example.issuetrackerrest.entity.UserDTO;
import com.example.issuetrackerrest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Api(tags = "User")
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/users";

    @Autowired
    private final UserService mUserService;

    public UserController(UserService mUserService) {
        this.mUserService = mUserService;
    }

    @ApiOperation(value = "Busca tots els usuaris",
            notes = "Busca tots els usuaris creats fins al moment",
            responseContainer = "List",
            response = User.class)
    @GetMapping()
    public List<User> getAllUsers() {
        return mUserService.findAllUsers();
    }

    @ApiOperation(value = "Busca un usuari per id",
            notes = "Busca l'usuari amb el id especificat",
            response = User.class)
    @GetMapping("/{id}")
    public User getUserById (@PathVariable Long id){
        return mUserService.findUserById(id);
    }

    @ApiOperation(value = "Busca un usuari pel username",
            notes = "Busca l'usuari amb el username especificat",
            response = User.class)
    @GetMapping("/username")
    public User getUserByUsername (@RequestParam String username){
        return mUserService.findUserByUsername(username);
    }


    @ApiOperation(value = "Crea un usuari",
            notes = "crea un usuari amb les dades especificades",
            response = User.class)
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody UserDTO userDTO, @RequestHeader HttpHeaders headers) {
        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if(apikey == null || !apikey.equals("admin"))
            throw new IllegalArgumentException("Api-Key not valid");
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setApikey(userDTO.getApikey());
        user.setUrlfoto(userDTO.getUrlfoto());
        return mUserService.saveUser(user);
    }

    @ApiOperation(value = "Demana la Api-Key del usuari amb aquest username",
            notes = "retorna la api-key del usuari amb aquest username",
            response = User.class)
    @GetMapping("/apikey")
    public String getUserApiKey(@RequestParam String username, @RequestHeader HttpHeaders headers) {
        User user = mUserService.findUserByUsername(username);
        if (user == null) throw new NoSuchElementException();
        return user.getApikey() +
                "\n(Si tinguessim un sistema de login es podria fer que el usuari només pogués demanar la seva api-key)";
    }

}
