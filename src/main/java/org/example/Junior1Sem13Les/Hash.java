package org.example.Junior1Sem13Les;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Hash {
    static ArrayList<Integer> arr = getArray();
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random(1000);
    static HashMap<Integer,Integer> hashMap1 = new HashMap<>();
    static HashMap<Integer, Long> hashMap = new HashMap<>();

    public static void main(String[] args) {


//            task1();
            task2();

        }


    public static void task1(){
        for (int i = 0; i <5 ; i++) {
            System.out.println("Calculate factorial: ");
            int search = scanner.nextInt();
            System.out.println("Sum: " + getSum(search));
        }
    }
    public static void task2(){
        for (int i = 0; i <5 ; i++) {
            int search = scanner.nextInt();
            System.out.println("found: "+getAmountNumber(search));
        }
    }

    public static long getSum(int num){
        long t1 = System.currentTimeMillis();
        if (!hashMap.containsKey(num)){
            long res = 0;
            for (int i = 0; i <=num ; i++) {
                res+=num;
            }
            hashMap.put(num, res);
            long t2 = System.currentTimeMillis();
            System.out.println("Time: "+(t2-t1));
            return res;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time: "+(t2-t1));
        return hashMap.get(num);


    }

    public static ArrayList<Integer> getArray(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <100000000 ; i++) {
            int rand = (int) (Math.round(Math.random()*100)+1);
            arrayList.add(rand);
        }
        System.out.println(arrayList);
        return arrayList;

    }
    public static int getAmountNumber(int find){
        long t1 = System.currentTimeMillis();
        if (!hashMap1.containsKey(find)){
        int count = 0;
        for (int i = 0; i <arr.size() ; i++) {
            if (arr.get(i)==find){
                count++;
            }
        }
        hashMap1.put(find,count);
            long t2 = System.currentTimeMillis();
            System.out.println("Time: "+(t2-t1));
        return count;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time: "+(t2-t1));
        return hashMap1.get(find);

    }
}