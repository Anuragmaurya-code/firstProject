package com.example.firstProject.repository;

import com.example.firstProject.modal.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars,Long> {
}
