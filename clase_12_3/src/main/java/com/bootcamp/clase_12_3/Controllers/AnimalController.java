package com.bootcamp.clase_12_3.Controllers;

import com.bootcamp.clase_12_3.Models.Animales;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    Animales[] animales = {
            new Animales(1, "juan", 16, "Ruptura de pierna", "caballo"),
            new Animales(2, "Oscar", 4, "Ruptura de ala", "gallina"),
            new Animales(3, "Eduardo", 5, "alergia a las pulgas", "perro"),
            new Animales(4, "tom", 2, "alergia a otros gatos", "gato")
    };

    @PostMapping("/save_animal")
    public Animales saveAnimal(@RequestBody Animales animal){
        animal.setId(animales.length + 1);
        return animal;
    }

    @GetMapping("/get_all_animals")
    public Animales[]  getAllAnimals(){
        return animales;
    }

    @GetMapping("/get_one_animal/{id}")
    public Animales getAnimal(@PathVariable(name = "id") int id) {
        if (((id - 1) > (animales.length - 1)) || ((id - 1) < 0)) {
            return new Animales(0, null, 0, null, null);
        }
     return animales[id-1];
    }
}
