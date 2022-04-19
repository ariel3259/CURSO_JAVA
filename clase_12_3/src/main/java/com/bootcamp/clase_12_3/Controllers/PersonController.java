package com.bootcamp.clase_12_3.Controllers;

import com.bootcamp.clase_12_3.Models.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    Person[] people = {
            new Person(1, "Charles", "Morris"),
            new Person(2, "Tracey", "Ramos"),
            new Person(3, "Michael", "Lawson"),
            new Person(4, "Lindsay", "Ferguson")
    };

    @PostMapping("/save_person")
    public Person savePerson(@RequestBody Person person){
        person.setId(people.length + 1);
        return person;
    }

    @GetMapping("/get_all_people")
    public Person[] getAllPeople(){
        return people;
    }

    @GetMapping("/get_one_people/{id}")
    public Person getOnePerson(@PathVariable(name = "id") int id){
        if(((id - 1) > (people.length - 1)) || ((id - 1) < 0)){
            return new Person(0, null, null);
        }
        return people[id-1];
    }

}
