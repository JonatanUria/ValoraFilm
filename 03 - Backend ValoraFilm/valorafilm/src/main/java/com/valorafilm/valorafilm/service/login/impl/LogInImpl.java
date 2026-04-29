package com.valorafilm.valorafilm.service.login.impl;

import com.valorafilm.valorafilm.database.entities.Usuario;
import com.valorafilm.valorafilm.database.repositories.UsuarioRepository;
import com.valorafilm.valorafilm.service.login.Login;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class LogInImpl implements Login {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public ResponseEntity<?> login(String username, String password) throws Exception {

        String passwordHasheada = md5(password);
        log.info("La contraseña introducida es " + password);
        log.info("La contraseña hasheada es " + passwordHasheada);
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNamePasswordUsuario(username,passwordHasheada);

        if (usuarioOpt.isPresent()){
            log.info("El usuario ha iniciado sesión correctamente");
            Usuario usuario = usuarioOpt.get();

            Long idUsuario = (long) usuario.getIdUsuario();

            String token = generarToken(idUsuario);

            ResponseCookie cookie = ResponseCookie.from("token", token)
                    .httpOnly(true)
                    .secure(false)
                    .path("/")
                    .maxAge(3600)
                    .build();

            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).build();


        } else {
            log.error("El usuario no está en la base de datos.");
            return ResponseEntity
                    .status(401)
                    .body("No se encuentra en la base de datos el usuario");
        }
    }

    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String generarToken(Long userId) {

        return Jwts.builder()
                .setSubject(String.valueOf(userId)) // Aquí pondremos el ID
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS256, "OAOSKDOPASKDPCMZXKLMAOSKDOPASMKPASASDJLZXLCA")
                .compact();
    }


}
