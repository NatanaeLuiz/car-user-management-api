package com.pitang.car_user_management_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Data
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer year;

    @NotBlank
    @Size(max = 20)
    private String licensePlate;

    @NotBlank
    @Size(max = 80)
    private String model;

    @NotBlank
    @Size(max = 30)
    private String color;
}
