package com.berrinakan.garageservice.controller;

import com.berrinakan.garageservice.exception.ParkingException;
import com.berrinakan.garageservice.model.Garage;
import com.berrinakan.garageservice.model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class GarageControllerTest {

    WebTestClient webTestClient;
    GarageController garageController;

    @BeforeEach
    void setUp() throws Exception{
        garageController = Mockito.mock(GarageController.class);
        //webTestClient = WebTestClient.bindToController(garageController).build();
    }

    @Test
    void getGarageStatus() {
        Vehicle arac1 = new Vehicle("34-SO-1988","black","car",new int[1]);
        Garage garage1 = new Garage(arac1,true,false);
        int[] garageSlots = new int[] {1,2,3,4,5,6,7,8,9,10};

       assertEquals(garage1.isPark(),true);
       assertEquals(garage1.getVehicle().getSlots().length,1);
       System.out.println(garage1.getVehicle().getSlots().length +" slot yer ayrılmış.");

    }

    @Test
    void toPark() {
        Vehicle arac4 = new Vehicle("34-BB-1998","red","car",new int[1]);
        Garage garage4 = new Garage(arac4,true,false);
        int[] garageSlots = new int[] {1,2,3,4,5,6,7,8,9,10};
        try {
            IntStream stream = Arrays.stream(garageSlots, 10, 11);
            garage4.getVehicle().setSlots(stream.toArray());
        }catch (ArrayIndexOutOfBoundsException e){
            throw new ParkingException("Garage is full");
        }

        //45.satırda startInclusive 9 endExclusive 10 verildiğinde arrayin boyutu aşılmıyor
        //bu durumdada testden geçiyor fakat bu testi exception test etmek için yazdım
        //böylece ArrayIndexBoundException yakaladığımız için ParkingExeptionın çalıştığınıda görmüş olduk.

    }
}