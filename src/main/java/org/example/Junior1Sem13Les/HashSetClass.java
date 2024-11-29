package org.example.Junior1Sem13Les;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class HashSetClass {
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println(getNumberPhone().size());
        HashSet<String> hashSet = new HashSet<>(getNumberPhone());
        System.out.println(hashSet.size());
        double proc = ((double) getNumberPhone().size() /hashSet.size() - 1)*100;
        System.out.println(proc);
    }
    public static ArrayList<String> getNumberPhone(){
        ArrayList<String> arrayList = new ArrayList<>();


        for (int i = 0; i <1000000 ; i++) {
            String phone = "+37525";
            for (int j = 0; j <7 ; j++) {
                phone+=(Math.round(Math.random() * 9) + 1);
            }
            arrayList.add(phone);
        }
        return arrayList;
    }
}
