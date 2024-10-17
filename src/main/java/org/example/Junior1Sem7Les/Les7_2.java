package org.example.Junior1Sem7Les;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Les7_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[][] arr = new String[10][10];
        for (int i = 0; i < arr.length ; i++) {
            String name = scanner.nextLine();
            arr[i][0] = name;
            for (int j = 1; j <arr[i].length ; j++) {
                arr[i][j] = String.valueOf(random.nextInt(11));
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.toString(check(arr)));

    }
    public static String[] check(String[][]arr){
        String[]arrString = new String[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            double av = 0;
            for (int j = 1; j <arr[i].length ; j++) {
                av+=Integer.parseInt(arr[i][j]);
                if (j == arr[i].length-1){
                    arrString[i] = arr[i][0]+":"+av/j;
                }
            }
        }
        return arrString;
    }
}
