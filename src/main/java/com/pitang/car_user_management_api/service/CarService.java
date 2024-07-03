package com.pitang.car_user_management_api.service;

import com.pitang.car_user_management_api.entity.Car;

import java.util.List;

public interface CarService {

    Car findById(Long id);

    List<Car> findAllCars();

    void createCar(Car car);

    void updateCar(Long id, Car car);

    void removeCar(Long id);
}
