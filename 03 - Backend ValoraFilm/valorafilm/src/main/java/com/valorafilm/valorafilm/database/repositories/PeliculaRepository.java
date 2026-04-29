package com.valorafilm.valorafilm.database.repositories;


import com.valorafilm.valorafilm.database.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeliculaRepository extends JpaRepository <Pelicula, Integer> {
    @Query("SELECT s FROM Pelicula s WHERE s.idUsuarioAlta = :idUsuarioAlta")
    List<Pelicula> findByIdUsuario(@Param("idUsuarioAlta") int idUsuarioAlta);

}
