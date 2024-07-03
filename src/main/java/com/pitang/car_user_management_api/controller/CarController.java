package com.pitang.car_user_management_api.controller;

import com.pitang.car_user_management_api.entity.Car;
import com.pitang.car_user_management_api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> findAllCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.findById(id));
    }

    @PostMapping("/cars/create")
    public ResponseEntity<Car> createUser(@RequestBody Car car) {
        carService.createCar(car);
        return ResponseEntity.ok(car);
    }

    @PutMapping("/cars/update/{id}")
    public ResponseEntity<Car> updateUser(@PathVariable Long id, @RequestBody Car car) {
        carService.updateCar(id, car);
        return ResponseEntity.ok(car);
    }

    @DeleteMapping("/cars/remove/{id}")
    public ResponseEntity<?> removeUser(@PathVariable Long id) {
        carService.removeCar(id);
        return ResponseEntity.ok().build();
    }
}
