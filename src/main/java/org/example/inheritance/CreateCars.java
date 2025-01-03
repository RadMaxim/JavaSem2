package org.example.inheritance;

import lombok.Builder;

import java.nio.file.attribute.AclEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateCars {
    static List<Object> cars = new ArrayList<>();
    public static void main(String[] args) {

        CarElectric carElectric = new CarElectric("Tesla",300,2008,"W200");
        Truck truck = new Truck("Track1",200,1996,2.7,3000);
        Sedan sedan = new Sedan("Sedan",250,2004);
        cars = Arrays.asList(carElectric, truck, sedan);
        for (Object car : cars) {
            System.out.println(car);
        }
    }
}
