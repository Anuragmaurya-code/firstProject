package com.example.firstProject.controller;


import com.example.firstProject.modal.Animal;
import com.example.firstProject.repository.AnimalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController {
    private final AnimalRepository animal;

    public AnimalController(AnimalRepository animal) {
        this.animal=animal;
    }

    @GetMapping("/animal")
    public List<Animal> getAnimal(){
        return animal.findAll();
    }

    @PostMapping("/animal")
    public Animal postAnimal(@RequestBody Animal newAnimal){
        Animal savedAnimal=animal.save(newAnimal);
        return savedAnimal;

    }
}
