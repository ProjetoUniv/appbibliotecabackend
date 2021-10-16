package com.project.controledelivros.service;

import com.project.controledelivros.exceptions.BusinessException;
import com.project.controledelivros.exceptions.NotFoundException;
import com.project.controledelivros.mapper.LivroMapper;
import com.project.controledelivros.model.Livro;
import com.project.controledelivros.model.Usuario;
import com.project.controledelivros.model.dto.LivroDTO;
import com.project.controledelivros.repository.LivroRepository;
import com.project.controledelivros.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private LivroMapper mapper;

    @Transactional
    public LivroDTO saveBooks(LivroDTO dto) {
        Livro books = mapper.toEntity(dto);
        repository.save(books);
        return mapper.toDto(books);
    }


    @Transactional(readOnly = true)
    public List<LivroDTO> findAllBooks() {
        return mapper.toDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public LivroDTO findByIdBooks(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public LivroDTO deleteBooks(Long id) {
        LivroDTO dto = this.findByIdBooks(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Transactional
    public Boolean findByExistsBooksforTileandImage(String title, String nameImage) {
        Optional<Livro> booksTitleImage  = repository.findByExistsBooksforTileandImage(title, nameImage);
        if(booksTitleImage.isPresent()){
            return  true;
        }
        return false;
    }

    @Transactional
    public Boolean findByExistsBooksforIsbn(String isbn) {
        Optional<Livro> booksIsbn  = repository.findByExistsBooksforIsbn(isbn);
        if(booksIsbn.isPresent()){
            return  true;
        }
        return false;
    }

    @Transactional
    public LivroDTO updateBooks(LivroDTO dto) {

        Optional<Livro> optionalBooks= repository.findByBooksUpdate(dto.getId());

        if (optionalBooks.isPresent() == false){
            throw new BusinessException(MessageUtils.BOOKS_EXISTS);
        }

        Livro books = mapper.toEntity(dto);
        repository.save(books);
        return mapper.toDto(books);
    }
}
