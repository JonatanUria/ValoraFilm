package com.valorafilm.valorafilm.controller.toLearn;


import com.valorafilm.valorafilm.controller.toLearn.model.Coche;
import org.springframework.web.bind.annotation.*;


/*
*   Los restController son para definir las APIs
* */
@RestController
public class FirstControllerTest {

    @GetMapping("/get")
    public String holaMundo() {
        return "GET - Hola mundo...";
    }

    /// ---
    @PostMapping("/post")
    public String holaMundo1() {
        return "POST - Hola mundo1...";
    }

    /// ---
    @PutMapping("/put")
    public String holaMundo2() {
        return "PUT - Hola mundo2...";
    }

    /// ---
    @DeleteMapping("/delete")
    public String holaMundo3() {
        return "DELETE - Hola mundo3...";
    }

    @GetMapping("/coche")
    public Coche coche() {
        Coche coche1 = new Coche("Peugeot", "9765N");
        return coche1;
    }


    // ArithmeticalController




}
