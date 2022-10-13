package com.berrinakan.garageservice.controller;

import com.berrinakan.garageservice.exception.ParkingException;
import com.berrinakan.garageservice.model.Garage;
import com.berrinakan.garageservice.model.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static  org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/garages")
public class GarageController {
    Vehicle arac1 = new Vehicle("34-SO-1988","black","car",new int[1]);
    Vehicle arac2 = new Vehicle("34-BO-1987","red","truck",new int[4]);
    Vehicle arac3 = new Vehicle("34-VO-2018","blue","jeep",new int[2]);

    Garage garage1 = new Garage(arac1,true,false);
    Garage garage2 = new Garage(arac2,true,false);
    Garage garage3 = new Garage(arac3,true,false);

    int[] garageSlots = new int[] {1,2,3,4,5,6,7,8,9,10};
    List<Garage> garages;


    @GetMapping
    public ResponseEntity<List<Garage>> getGarageStatus(){

        if(arac1.getTur() =="car"){
            IntStream stream = Arrays.stream(garageSlots, 0, 1);
            arac1.setSlots(stream.toArray());

        }
        if(arac2.getTur() =="truck") {
            IntStream stream2 = Arrays.stream(garageSlots, 2, 6);
            arac2.setSlots(stream2.toArray());
        }
        if(arac3.getTur() =="jeep") {
            IntStream stream3 = Arrays.stream(garageSlots, 7, 9);
            arac3.setSlots(stream3.toArray());
        }
         garages = Arrays.asList(garage1,garage2,garage3);
        return new ResponseEntity<>(garages, OK);
    }
   @PostMapping
    public ResponseEntity<List<Garage>> toPark(@RequestBody Garage newGarage){

        garages = Arrays.asList(garage1, garage2, garage3, newGarage);
        try {
            IntStream stream = Arrays.stream(garageSlots, 10, 11);
            newGarage.getVehicle().setSlots(stream.toArray());
        }catch (ArrayIndexOutOfBoundsException e){
            throw new ParkingException("Garage is full");
        }


            return new ResponseEntity<>(garages, HttpStatus.CREATED);

  }


}
