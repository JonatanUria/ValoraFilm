package com.valorafilm.valorafilm.service.login;

import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseEntity;

public interface Login {
    ResponseEntity<?> login(String username, String password) throws Exception;
}
