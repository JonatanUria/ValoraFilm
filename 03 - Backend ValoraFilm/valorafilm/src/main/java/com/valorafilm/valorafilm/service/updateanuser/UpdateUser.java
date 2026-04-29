package com.valorafilm.valorafilm.service.updateanuser;

import java.time.LocalDate;

public interface UpdateUser {
    void updateUser(int userId, String username, String email, String password, LocalDate birthdate);
}
