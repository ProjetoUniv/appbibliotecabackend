package com.project.controledelivros.controller;


import com.project.controledelivros.model.dto.UsuarioDTO;
import com.project.controledelivros.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/usuarios")
@Tag(name = "Cadastro de Usuários")
public class UsuarioController {


    @Autowired
    private UsuarioService service;


    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> saveUsers(@Valid @RequestBody UsuarioDTO dto){
            return  ResponseEntity.ok(service.saveUsers(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> updateUsers(@Valid @RequestBody UsuarioDTO dto){
        return  ResponseEntity.ok(service.updateUsers(dto));
    }

    @Operation(summary = "Listar todo os usuários")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDTO>> findAllUsers(){
        return  ResponseEntity.ok(service.findAllUsers());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> findByIdUsers(@PathVariable Long id){
        return  ResponseEntity.ok(service.findByIdUsers(id));
    }

    @GetMapping(value = "/email/{email}/password/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean findByEmailandPasswordExists(@PathVariable String email, @PathVariable String password){
        Boolean result =  service.findByEmailandPasswordExists(email, password);
        if (result){
            return true;
        }
        return false;
    }

    @GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean  findByEmailExists(@PathVariable String email, HttpServletResponse response){
       Boolean emailBanco =  service.findByEmailExists(email);
       if (emailBanco ){
           return true;
       }
           return false;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> deleteUsers(@PathVariable Long id){
        return  ResponseEntity.ok(service.deleteUsers(id));
    }

}
