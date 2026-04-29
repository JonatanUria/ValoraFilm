package com.valorafilm.valorafilm.database.repositories;

import com.valorafilm.valorafilm.database.entities.Sinopsis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SinopsisRepository extends JpaRepository<Sinopsis, Integer> {
    @Query("SELECT s FROM Sinopsis s WHERE s.idPelicula = :idPelicula")
    Sinopsis buscarPorId(@Param("idPelicula") Integer idPelicula);

}
