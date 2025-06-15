package com.na.backend.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.na.backend.model.Usuario;
import com.na.backend.repository.UsuarioRepository;
import com.na.backend.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Metodo para obtener el ultimo codigo de usuario
    @Override
    public String obtenerUltimoCodigoUsuario() {
        return usuarioRepository.obtenerUltimoCodigo();
    }

    // Metodo para buscar un usuario por su username
    @Override
    public List<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    // VALIDACION DE USUARIO EXISTE
    @Override
    public boolean usuarioExistePorUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    // VALIDACION DE USUARIO Y CONTRASEÑA
    @Override
    public boolean existsByUsernameAndPassword(String username, String password) {
        return usuarioRepository.existsByUsernameAndPassword(username, password);
    }
}