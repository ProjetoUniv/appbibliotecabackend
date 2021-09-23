package com.project.controledelivros.controller;


import com.project.controledelivros.model.dto.LivroDTO;
import com.project.controledelivros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/livrosbiblioteca")
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> saveBooks(@Valid @RequestBody LivroDTO dto){
        return  ResponseEntity.ok(service.saveBooks(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LivroDTO>> findAllBooks(){
        return  ResponseEntity.ok(service.findAllBooks());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> findByIdBooks(@PathVariable Long id){
        return  ResponseEntity.ok(service.findByIdBooks(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> deleteBooks(@PathVariable Long id){
        return  ResponseEntity.ok(service.deleteBooks(id));
    }

}
