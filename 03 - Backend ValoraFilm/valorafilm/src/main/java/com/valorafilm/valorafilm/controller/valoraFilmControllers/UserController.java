package com.valorafilm.valorafilm.controller.valoraFilmControllers;


import com.valorafilm.valorafilm.service.deleteanuser.impl.DeleteUserImpl;
import com.valorafilm.valorafilm.service.login.impl.LogInImpl;
import com.valorafilm.valorafilm.service.login.model.RequestLogIn;
import com.valorafilm.valorafilm.service.modifyusertype.impl.ModifyUserTypeImpl;
import com.valorafilm.valorafilm.service.obtainanuser.impl.ObtainAnUserImpl;
import com.valorafilm.valorafilm.service.obtainanuser.model.ObtainUserResponse;
import com.valorafilm.valorafilm.service.obtainfilmsbyuser.impl.ObtainFilmsByUserImpl;
import com.valorafilm.valorafilm.service.obtainfilmsbyuser.model.ObtainFilmsByUserResponse;
import com.valorafilm.valorafilm.service.obtainusers.impl.ObtainUsersImpl;
import com.valorafilm.valorafilm.service.obtainusers.model.ObtainUsersResponse;
import com.valorafilm.valorafilm.service.registeranuser.impl.RegisterUserImpl;
import com.valorafilm.valorafilm.service.registeranuser.model.RequestRegisterUser;
import com.valorafilm.valorafilm.service.updateanuser.impl.UpdateUserImpl;
import com.valorafilm.valorafilm.service.updateanuser.model.RequestUpdateUser;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UpdateUserImpl updateService;
    @Autowired
    private RegisterUserImpl registerUser;
    @Autowired
    private ObtainUsersImpl obtainUsers;
    @Autowired
    private UpdateUserImpl updateUser;
    @Autowired
    private ModifyUserTypeImpl modifyUserType;
    @Autowired
    private DeleteUserImpl deleteUser;
    @Autowired
    private ObtainAnUserImpl obtainAnUser;
    @Autowired
    private ObtainFilmsByUserImpl obtainFilmsByUser;
    @Autowired
    private LogInImpl logIn;


    @PostMapping("/newuser")
    public void registerUser(@Valid @RequestBody RequestRegisterUser request) {
        System.out.println("El usuario es " + request.getUsername());
        System.out.println("El email es " + request.getEmail());
        System.out.println("La contraseña es " + request.getPassword());
        System.out.println("La fecha de nacimiento es " + request.getBirthdate());

        registerUser.registerUser(request.getUsername(),
                request.getEmail(), request.getPassword(), request.getBirthdate());

        log.info("Usuario dado de alta correctamente.");
    }

    @PutMapping("/updateuser/{userId}")
    public void updateUser(@PathVariable int userId, @Valid @RequestBody RequestUpdateUser request) {
        System.out.println("El usuario es " + request.getUsername());
        System.out.println("El email es " + request.getEmail());
        System.out.println("La contraseña es " + request.getPassword());
        System.out.println("La fecha de nacimiento es " + request.getBirthdate());

        updateUser.updateUser(userId, request.getUsername(), request.getEmail(), request.getPassword(), request.getBirthdate());

        log.info("Los datos del usuario " + userId + " fueron modificados correctamente.");
    }

    @GetMapping("/obtainusers")
    public List<ObtainUsersResponse> obtainUsers() {
        return obtainUsers.obtainUsers();
    }

    @PutMapping("/modifyusertype/{userId}")
    public void modifyUserType(@PathVariable int userId) {
        System.out.println(userId);

        modifyUserType.modifyUserType(userId);
    }

    @DeleteMapping("/deleteuser/{userId}")
    public void deleteUser(@PathVariable int userId) {
        System.out.println(userId);

        deleteUser.deleteUser(userId);

        log.info("El usuario se ha dado de baja correctamente.");

    }

    @GetMapping("/obtainanuser/{userId}")
    public ObtainUserResponse obtainAnUser(@PathVariable int userId) {
        System.out.println(userId);

        return obtainAnUser.obtainUser(userId);


    }

    @GetMapping("/obtainfilmsbyuser/{userId}")
    public List<ObtainFilmsByUserResponse> obtainFilmsByUser(@PathVariable int userId) {
        System.out.println(userId);

        return obtainFilmsByUser.obtainFilmsByUser(userId);

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody RequestLogIn request) throws Exception {
        log.info("Este es el nombre del usuario " + request.getUsername());
        log.info("Esta es la contraseña introducida " + request.getPassword());

        ResponseEntity<?> login = logIn.login(request.getUsername(), request.getPassword());

        log.info("El usuario ha iniciado sesión correctamente.");

        return login;

    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {

        Cookie cookie = new Cookie("token", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return ResponseEntity.ok("Logout correcto");
    }
    @GetMapping("/auth/me")
    public ResponseEntity<?> checkLogin (@CookieValue(value = "token", required = false) String token) {

        log.info("Entramos al checkLogin 1");
        // Se devolvería el 401, porque las credenciales son incorrectas ó no tiene TOKEN.
        if (token == null) {
            return ResponseEntity.status(401).build();
        }

        String userId = Jwts
                .parser()
                .setSigningKey("OAOSKDOPASKDPCMZXKLMAOSKDOPASMKPASASDJLZXLCA")
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        log.info("Entramos al checkLogin 2");

        if (userId.isBlank() ||userId.isEmpty()) {
            return ResponseEntity.status(401).build();
        }
        log.info("Entramos al checkLogin 3");

        return ResponseEntity.ok(userId);
    }
}


