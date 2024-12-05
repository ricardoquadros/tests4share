package com.auth.users.controller;

import com.auth.users.service.UsuarioService;
import com.auth.users.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
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
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String usuario, @RequestParam String senha) {
        // Sample 1
        return usuarioService.autenticar(usuario, senha)
                .<ResponseEntity<?>>map(user -> {
                    String token = jwtUtil.generateToken(usuario);
                    return ResponseEntity.ok(Map.of("token", token));
                })
                .orElseGet(() -> ResponseEntity.status(401).body("Usuário ou senha inválidos"));
    }

/*
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        // Sample 2
        String usuario = loginData.get("usuario");
        String senha = loginData.get("senha");
        Map<String, String> erroResponse = Map.of("erro", "Usuário ou senha inválidos");

        return usuarioService.autenticar(usuario, senha)
                .map(user -> {
                    String token = jwtUtil.generateToken(usuario);
                    Map<String, String> response = Map.of("token", token);
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> ResponseEntity.status(401).body(erroResponse));
    }
*/

}
