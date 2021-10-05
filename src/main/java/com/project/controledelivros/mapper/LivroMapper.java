package com.project.controledelivros.mapper;

import com.project.controledelivros.model.Livro;
import com.project.controledelivros.model.dto.LivroDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LivroMapper {

    public Livro toEntity(LivroDTO dto) {
        Livro books = new Livro();
        books.setId(dto.getId());
        books.setTitle(dto.getTitle());
        books.setAuthor(dto.getAuthor());
        books.setCompany(dto.getCompany());
        books.setPositionShelf(dto.getPositionShelf());
        books.setDescription(dto.getDescription());
        books.setAgeGroup(dto.getAgeGroup());
        books.setNameImage(dto.getNameImage());
        return books;
    }

    public LivroDTO toDto(Livro books) {
        LivroDTO booksDto = new LivroDTO();
        booksDto.setId(books.getId());
        booksDto.setTitle(books.getTitle());
        booksDto.setAuthor(books.getAuthor());
        booksDto.setCompany(books.getCompany());
        booksDto.setPositionShelf(books.getPositionShelf());
        booksDto.setDescription(books.getDescription());
        booksDto.setAgeGroup(books.getAgeGroup());
        booksDto.setNameImage(books.getNameImage());
        return booksDto;
    }

    public List<LivroDTO> toDto(List<Livro> listBooks){
        return listBooks.stream().map(this::toDto).collect(Collectors.toList());
    }
}
