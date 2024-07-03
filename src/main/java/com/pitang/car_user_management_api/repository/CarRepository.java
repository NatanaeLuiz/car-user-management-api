package com.pitang.car_user_management_api.repository;

import com.pitang.car_user_management_api.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
    
}
