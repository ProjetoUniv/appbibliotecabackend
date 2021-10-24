package com.project.controledelivros.controller;


import com.project.controledelivros.model.dto.LivroDTO;
import com.project.controledelivros.model.dto.UsuarioDTO;
import com.project.controledelivros.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/livrosbiblioteca")
public class LivroController {

    @Autowired
    private LivroService service;

    @Operation(summary = "Salvar um livro no banco")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> saveBooks(@Valid @RequestBody LivroDTO dto){
        return ResponseEntity.ok(service.saveBooks(dto));
    }


    @Operation(summary = "Atualizar um livro no banco")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> updateBooks(@Valid @RequestBody LivroDTO dto){
        return  ResponseEntity.ok(service.updateBooks(dto));
    }

    @Operation(summary = "Listar todos os livros no banco")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LivroDTO>> findAllBooks(){
        return  ResponseEntity.ok(service.findAllBooks());
    }

    @Operation(summary = "Buscar um livro pelo seu ID cadastrador")
    @GetMapping(value = "/detalhes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> findByIdBooks(@PathVariable Long id){
        return  ResponseEntity.ok(service.findByIdBooks(id));
    }


    @Operation(summary = "Verificar se já existe um ISBN cadastrado com o numero digitado")
    @GetMapping(value = "/{isbn}}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean findByExistsBooksforIsbn(@PathVariable String isbn){
        Boolean booksExists =  service.findByExistsBooksforIsbn(isbn);
        if(booksExists){
            return  true;
        }
        return  false;
    }

    @Operation(summary = "Deletar um livro pelo seu id")
    @DeleteMapping(value = "/deletarlivro/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> deleteBooks(@PathVariable Long id){
        return  ResponseEntity.ok(service.deleteBooks(id));
    }

}
