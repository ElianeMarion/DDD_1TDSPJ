package br.com.fiap.service;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.dto.UsuarioRequestDto;
import br.com.fiap.dto.UsuarioResponseDto;

import java.sql.SQLException;

public class UsuarioService {
    private UsuarioDao usuarioDao = new UsuarioDao();

    public void cadastrar(UsuarioRequestDto usuarioDto) throws SQLException {
        usuarioDao.cadastrar(usuarioDto.convertToUsuario(usuarioDto));
    }

    public UsuarioResponseDto buscar(String login) throws SQLException {
        UsuarioResponseDto dto = new UsuarioResponseDto();
        return dto.convertToUsuarioResponseDto(usuarioDao.buscar(login));
    }
}
