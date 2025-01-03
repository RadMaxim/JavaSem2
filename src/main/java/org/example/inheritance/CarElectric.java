package org.example.inheritance;

import lombok.Builder;
import lombok.ToString;

//@ToString

public class CarElectric extends Car {
    public String battery;

    public CarElectric(String model, int maxSpeed, int yearOfManufacture, String battery) {
        super(model, maxSpeed, yearOfManufacture);
        this.battery = battery;
    }



}
