package com.berrinakan.garageservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    private String vehicleID;
    private String renk;
    private String tur;
    private int[] slots;


}
