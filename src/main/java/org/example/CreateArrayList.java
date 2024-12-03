package org.example;

import java.util.ArrayList;
import java.util.Random;


public class CreateArrayList {
    static Random random = new Random();
    public static ArrayList<Integer> createArrayList(int size){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <size ; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }
}
