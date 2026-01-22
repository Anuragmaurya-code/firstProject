package com.example.firstProject.controller;

import com.example.firstProject.Service.CarService;
import com.example.firstProject.modal.Cars;
import com.example.firstProject.repository.CarsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {

    private final CarService carService;
    public CarsController(CarService carService){this.carService=carService;}

    @GetMapping("")
    public List<Cars> getCars(){

        return carService.getCars();
    }
}
