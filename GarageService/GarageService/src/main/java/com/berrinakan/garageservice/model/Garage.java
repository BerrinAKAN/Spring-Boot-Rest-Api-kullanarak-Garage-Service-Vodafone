package com.berrinakan.garageservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Garage {

    private Vehicle vehicle;
    private boolean park;
    private boolean leave;

}
