package com.auth.users.service;

import com.auth.users.model.Usuario;
import com.auth.users.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Usuario> autenticar(String usuario, String senha) {
        //Commented once is just a test and the password doesn't need to be encrypted
        //return usuarioRepository.findByUsuario(usuario).filter(u -> passwordEncoder.matches(senha, u.getSenha()));
        return usuarioRepository.findByUsuario(usuario).filter(u -> senha.equals(u.getSenha()));
    }
}
