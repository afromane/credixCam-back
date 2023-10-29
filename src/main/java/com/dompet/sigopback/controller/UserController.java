package com.dompet.sigopback.controller;

import com.dompet.sigopback.dto.CatalogDTO;
import com.dompet.sigopback.dto.UserDTO;
import com.dompet.sigopback.entity.User;
import com.dompet.sigopback.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/user/",consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;


    @PostMapping()
    public void register(@RequestBody User user){
        log.info("Inscription");
        this.userService.create(user);

    }
    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll(){
        return new ResponseEntity<>( this.userService.findAll()
                .stream()
                .map(user -> modelMapper.map(user,UserDTO.class))
                .collect(Collectors.toList()), HttpStatus.OK );
    }
}
