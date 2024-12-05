package com.example.testopenapi.controller;

import com.example.testopenapi.repository.UsuarioRepository;
import com.example.testopenapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String usuario, @RequestParam String senha) {
        //String usuario = loginData.get("usuario");
        //String senha = loginData.get("senha");

        //.filter(u -> passwordEncoder.matches(senha, u.getSenha()))
        return usuarioRepository.findByUsuario(usuario)
                .filter(u -> senha.equals(u.getSenha()))
                .<ResponseEntity<?>>map(user -> {
                    String token = jwtUtil.generateToken(usuario);
                    return ResponseEntity.ok(Map.of("token", token));
                })
                .orElse(ResponseEntity.status(401).body("Usuário ou senha inválidos"));
    }
}
