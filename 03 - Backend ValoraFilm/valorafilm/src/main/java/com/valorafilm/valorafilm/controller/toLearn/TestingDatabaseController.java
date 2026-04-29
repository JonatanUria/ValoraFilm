package com.valorafilm.valorafilm.controller.toLearn;


import com.valorafilm.valorafilm.controller.toLearn.model.Coche;
import com.valorafilm.valorafilm.database.entities.Sinopsis;
import com.valorafilm.valorafilm.database.repositories.SinopsisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestingDatabaseController {


    @Autowired
    private SinopsisRepository sinopsisRepository;


    @GetMapping("/getHowManySinopsis")
    public String obtainHowManySummaries() {

        return "Hay " + sinopsisRepository.count() + " sinópsis guardadas en nuestra base de datos.";
    }

    @GetMapping("/obtainAllSumaries")
    public List<Sinopsis> obtainAllSummaries() {
        return sinopsisRepository.findAll();
    }

   @GetMapping("/obtainOnlySumaries")
    public List<String> obtainOnlySumaries(){
       List<Sinopsis> listSinopsis = sinopsisRepository.findAll();
       List<String> listaString = new ArrayList<>();

       for (Sinopsis sinopsis : listSinopsis) {
           listaString.add(sinopsis.getSinopsis());
       }

       return listaString;
   }
    @GetMapping("/obtenerId/{id}")
    public String obtainSinopsis(@PathVariable("id") int id){
        Sinopsis sinopsis = sinopsisRepository.buscarPorId(id);
        return sinopsis.getSinopsis();
    }
    @GetMapping("/obtenerlistasinopsis")
    public List<Sinopsis> obtainListaSinopsis() {
        return sinopsisRepository.findAll();
    }
}
