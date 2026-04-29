package com.valorafilm.valorafilm.database.repositories;

import com.valorafilm.valorafilm.database.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    @Query("SELECT s FROM Usuario s WHERE s.nombreUsuario = :nombreUsuario AND s.credencial = :credencial")
    Optional<Usuario> findByNamePasswordUsuario(@Param("nombreUsuario") String nombreUsuario, @Param("credencial") String credencial);


}
