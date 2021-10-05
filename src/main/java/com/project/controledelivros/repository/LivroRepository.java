package com.project.controledelivros.repository;

import com.project.controledelivros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {


    @Query("SELECT books " +
            "FROM Livro books " +
            "WHERE books.title =:title OR books.nameImage =:nameImage")
    Optional<Livro> findByExistsBooksforTileandImage(String title, String nameImage);
}
