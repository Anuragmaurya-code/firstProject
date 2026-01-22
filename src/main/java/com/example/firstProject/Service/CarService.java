package com.example.firstProject.Service;

import com.example.firstProject.modal.Cars;
import com.example.firstProject.repository.CarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarsRepository car;
    public CarService(CarsRepository car){this.car=car;}

    public List<Cars> getCars(){
        List<Cars> result= car.findAll();
        for(int i=0;i<result.toArray().length;i++){
            Cars c=result.get(i);
            c.setName("Anurag "+c.getName());
        }
        return result;
    }
}
