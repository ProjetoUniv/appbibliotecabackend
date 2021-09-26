package com.project.controledelivros.service;

import com.project.controledelivros.exceptions.BusinessException;
import com.project.controledelivros.exceptions.NotFoundException;
import com.project.controledelivros.mapper.UsuarioMapper;
import com.project.controledelivros.model.Usuario;
import com.project.controledelivros.model.dto.UsuarioDTO;
import com.project.controledelivros.repository.UsuarioRepository;
import com.project.controledelivros.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    @Transactional
    public UsuarioDTO saveUsers(UsuarioDTO dto) {
        Usuario users = mapper.toEntity(dto);
        if (users.getPassword().length() > 6) {
            throw new BusinessException(MessageUtils.MAX_PASSWORD);
        }
       repository.save(users);
       return mapper.toDto(users);
    }

    @Transactional
    public UsuarioDTO updateUsers(UsuarioDTO dto) {

        Optional<Usuario> optionalUsers = repository.findByUsersUpdate(dto.getEmail(), dto.getId());

        if (optionalUsers.isPresent()){
            throw new BusinessException(MessageUtils.EMAIL_EXISTS);
        }

        Usuario users = mapper.toEntity(dto);
        repository.save(users);
        return mapper.toDto(users);
    }

    @Transactional
    public UsuarioDTO deleteUsers(Long id) {
    UsuarioDTO dto = this.findByIdUsers(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAllUsers() {
        return mapper.toDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findByIdUsers(Long id) {
      return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Boolean findByEmailandPasswordExists(String email, String password) {
        Optional<Usuario> emailandPassword  = repository.findByEmailandPasswordExists(email, password);
        if(emailandPassword.isPresent()){
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean findByEmailExists(String email) {
        Optional<Usuario> emailUsers  = repository.findByEmail(email);
        if(emailUsers.isPresent()){
            return true;
        }
        return false;
    }

}
