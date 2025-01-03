package org.example.inheritance;

import lombok.Builder;
import lombok.ToString;

//@ToString

public class Sedan extends Car{
    public Sedan(String model, int maxSpeed, int yearOfManufacture) {
        super(model, maxSpeed, yearOfManufacture);
    }


}
