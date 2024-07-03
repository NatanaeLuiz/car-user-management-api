package com.pitang.car_user_management_api.service.impl;

import com.pitang.car_user_management_api.entity.Car;
import com.pitang.car_user_management_api.entity.User;
import com.pitang.car_user_management_api.repository.CarRepository;
import com.pitang.car_user_management_api.repository.UserRepository;
import com.pitang.car_user_management_api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService  {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }


    @Override
    public Car findById(Long id) {
        // Buscar Cliente por ID.
        Optional<Car> car = carRepository.findById(id);
        return car.get();
    }
    @Override
    public void createCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void updateCar(Long id, Car car) {
        Optional<Car> carBd = carRepository.findById(id);
        if (carBd.isPresent()) {
            createCar(car);
        }
    }

    @Override
    public void removeCar(Long id) {

        carRepository.deleteById(id);
    }
}
