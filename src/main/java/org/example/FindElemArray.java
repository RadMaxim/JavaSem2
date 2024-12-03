package org.example;

import java.util.ArrayList;

public class FindElemArray {
    public static int findElem(ArrayList<Integer> arrayList,int val){
        int count = 0;
        for (Integer integer : arrayList) {
            count++;
            if (integer == val){
                System.out.println(count);
                return integer;
            }
        }
        return 0;
    }
}
