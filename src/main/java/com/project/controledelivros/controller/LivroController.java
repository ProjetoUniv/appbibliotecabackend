package com.project.controledelivros.controller;


import com.project.controledelivros.model.dto.LivroDTO;
import com.project.controledelivros.model.dto.UsuarioDTO;
import com.project.controledelivros.service.LivroService;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> saveBooks(@Valid @RequestBody LivroDTO dto){

        return ResponseEntity.ok(service.saveBooks(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> updateBooks(@Valid @RequestBody LivroDTO dto){
        if(dto.getNameImage().contains("livro")){
           return ResponseEntity.ok(service.updateBooks(dto));
        }
        dto.setNameImage(String.valueOf("livro" + dto.getNameImage()));
        return  ResponseEntity.ok(service.updateBooks(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LivroDTO>> findAllBooks(){
        return  ResponseEntity.ok(service.findAllBooks());
    }

    @GetMapping(value = "/detalhes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> findByIdBooks(@PathVariable Long id){
        return  ResponseEntity.ok(service.findByIdBooks(id));
    }

    @GetMapping(value = "/{title}/{nameImage}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean findByExistsBooksforTileandImage(@PathVariable String title, @PathVariable String nameImage){
        Boolean booksExists =  service.findByExistsBooksforTileandImage(title, nameImage);
        if(booksExists){
            return  true;
        }
        return  false;
    }

    @GetMapping(value = "/{isbn}}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean findByExistsBooksforIsbn(@PathVariable String isbn){
        Boolean booksExists =  service.findByExistsBooksforIsbn(isbn);
        if(booksExists){
            return  true;
        }
        return  false;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDTO> deleteBooks(@PathVariable Long id){
        return  ResponseEntity.ok(service.deleteBooks(id));
    }

}
