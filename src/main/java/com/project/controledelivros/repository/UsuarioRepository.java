package com.project.controledelivros.repository;

import com.project.controledelivros.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query("SELECT users " +
            "FROM Usuario users " +
            "WHERE users.email =:email AND users.id  <> :id  ")
    Optional<Usuario> findByUsersUpdate(String email, Long id);

    @Query("SELECT users " +
            "FROM Usuario users " +
            "WHERE users.email =:email AND users.password =:password ")
    Optional<Usuario> findByEmailandPasswordExists(String email, String password);
}
