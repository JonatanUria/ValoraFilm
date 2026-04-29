package com.valorafilm.valorafilm.database.repositories;

import com.valorafilm.valorafilm.database.entities.Critica;
import com.valorafilm.valorafilm.database.entities.CriticaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriticaRepository extends JpaRepository<Critica, CriticaId> {
    @Query("SELECT s FROM Critica s WHERE s.id.idUsuario = :idUsuario")
    List<Critica> findByIdUsuario(@Param("idUsuario") int idUsuario);

    @Query("SELECT s FROM Critica s WHERE s.id.idPelicula = :idPelicula")
    List<Critica> findByIdPelicula(@Param("idPelicula") int idPelicula);
}
