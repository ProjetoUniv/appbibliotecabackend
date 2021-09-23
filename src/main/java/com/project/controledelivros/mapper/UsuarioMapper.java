package com.project.controledelivros.mapper;


import com.project.controledelivros.model.Usuario;
import com.project.controledelivros.model.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario users = new Usuario();
        users.setId(dto.getId());
        users.setName(dto.getName());
        users.setEmail(dto.getEmail());
        users.setPassword(dto.getPassword());
        return users;
    }

    public UsuarioDTO toDto(Usuario users) {
        UsuarioDTO usersDto = new UsuarioDTO();
        usersDto.setId(users.getId());
        usersDto.setName(users.getName());
        usersDto.setEmail(users.getEmail());
        usersDto.setPassword(users.getPassword());
        return usersDto;
    }

    public List<UsuarioDTO> toDto(List<Usuario> listStock){
        return listStock.stream().map(this::toDto).collect(Collectors.toList());
    }

}
