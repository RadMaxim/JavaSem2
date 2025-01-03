package org.example.polymorphism;

import org.example.inheritance.Car;
import org.example.inheritance.CarElectric;
import org.example.inheritance.Sedan;
import org.example.inheritance.Truck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        List<Car> cars;
        Car car = new CarElectric("m1",300,2006,"b1");
        Car car1 = new CarElectric("m2",200,2004,"b2");
        Car car2 = new Sedan("m3",400,2001);
        Car car3 = new Truck("m4",350,2023,3.5,5.8);
        cars = Arrays.asList(car,car1,car2,car3);
        System.out.println(cars);
        for (Car car4 : cars) {
            System.out.println(car4);

        }
    }
}
