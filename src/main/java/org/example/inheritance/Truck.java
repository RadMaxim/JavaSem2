package org.example.inheritance;

import lombok.Builder;
import lombok.ToString;

//@ToString

public class Truck extends Car{


    public double towing;
    public double separateCabin;


    public Truck(String model, int maxSpeed, int yearOfManufacture, double towing, double separateCabin) {
        super(model, maxSpeed, yearOfManufacture);
        this.separateCabin = separateCabin;
        this.towing = towing;

    }
}
