package com.valorafilm.valorafilm.controller.toLearn;

import com.valorafilm.valorafilm.controller.toLearn.model.Libro;
import com.valorafilm.valorafilm.service.registeranuser.impl.RegisterUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArithmeticalController {

    // Calcule el doble de un numero por parámetro,
    // Calcule el triple de un numero por parámetro,

    // Calcula la suma, resta, multi, divi, de DOS parámetros por entrada
    // Un metodo que devuelva un objeto Libro

    @Autowired
    private RegisterUserImpl registerServiceImpl;

    @GetMapping("/obtenernumero/{numero}")
    public String obtenerNumero(@PathVariable("numero") int numero) {

        return "El parámetro es el dos " + numero;
    }

    @GetMapping("/obtenerdoblenumero/{numero}")
    public String obtenerDobleNumero(@PathVariable("numero") int numero) {
        int resultado = numero * 2;

        return "El doble del " + numero + " es " + resultado;
    }

    @GetMapping("/obtenertriplenumero/{numero}")
    public String obtenerTripleNumero(@PathVariable("numero") int numero) {
        int resultado = numero * 3;

        return "El triple del " + numero + " es " + resultado;
    }

    @GetMapping("/obtenertodonumeros/{numero1}/{numero2}")
    public String obtenerTodasOperaciones(@PathVariable("numero1") int numero1, @PathVariable("numero2") int numero2) {
        int resultadoSuma = numero1 + numero2;
        int resultadoResta = numero1 - numero2;
        int resultadoMultiplicacion = numero1 * numero2;
        int resultadoDivision = numero1 / numero2;

        return "El resutlado de la suma de " + numero1 + " y " + numero2 + " es " + resultadoSuma + ",\nEl "
                + "resultado de la resta de " + numero1 + " y " + numero2 + " es " + resultadoResta + ",\nEl "
                + "resultado de la multiplicacion de " + numero1 + " y " + numero2 + " es " + resultadoMultiplicacion + ",\nEl "
                + "resultado de la division de " + numero1 + " y " + numero2 + " es " + resultadoDivision;
    }

    @GetMapping("/libro")
    public Libro libro () {
        Libro libro1 = new Libro();
        libro1.setTitulo("La vida de Juan");
        libro1.setAutor("Enrique Palacios");
        libro1.setGenero("Comedia");
        libro1.setEditorial("Amaya");
        libro1.setNumeroPaginas(487);
        libro1.setFechaPublicacion("23/06/2013");

        return libro1;

    }

}
