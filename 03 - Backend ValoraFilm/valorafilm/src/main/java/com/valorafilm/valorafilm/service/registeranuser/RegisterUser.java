package com.valorafilm.valorafilm.service.registeranuser;

import java.time.LocalDate;

public interface RegisterUser {


    void registerUser(String username, String email, String password, LocalDate birthdate);
}
