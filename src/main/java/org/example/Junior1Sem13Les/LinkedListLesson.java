package org.example.Junior1Sem13Les;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListLesson {
    public static ArrayList<Integer> numbersArrayList = new ArrayList<>();
    public static LinkedList<Integer> numbersLinkedList = new LinkedList<>();
    public static Scanner scanner = new Scanner(System.in);
    static {
        for (int i = 0; i < Math.pow(10,1)/2; i++) {
            numbersArrayList.add(i);
            numbersLinkedList.add(i);
        }

    }
    public static void main(String[] args) {
//        task1(); // Проверяем время работы удаления первого элемента и прибавления первого элемента связанного списка связанного списка
//        task2();// время обращения к элементу списка
            task3();
    }
    public static void task1(){
        System.out.println("Remove start");
        long t1 = System.currentTimeMillis();
        numbersArrayList.removeFirst();
        for (int i = 0; i <Math.pow(10,3) ; i++) {
            numbersArrayList.addFirst(i);
        }
        numbersArrayList.addFirst(1);
        long t2 = System.currentTimeMillis();
        numbersLinkedList.removeFirst();
        for (int i = 0; i <Math.pow(10,3) ; i++) {
            numbersLinkedList.addFirst(i);
        }

        long t3 = System.currentTimeMillis();
        System.out.println("ArrayList: "+(t2-t1));
        System.out.println("LinkedList: "+(t3-t2));
    }
    public static void task2(){
        long t1 = System.currentTimeMillis();
        System.out.println(numbersArrayList.get((int) Math.pow(10,7)));
        long t2 = System.currentTimeMillis();
        System.out.println(numbersLinkedList.get((int) Math.pow(10,7)));
        long t3 = System.currentTimeMillis();
        System.out.println("ArrayList: "+(t2-t1));
        System.out.println("LinkedList: "+(t3-t2));
    }
    public static void task3(){
        LinkedList<String> names = new LinkedList<>();
        while (true){
            System.out.println("Enter name: ");
            String name = scanner.next();
            names.addFirst(name);
            if (names.size()==5){
                System.out.println(names.get(4)+" was remove from history of brawser");
                names.removeLast();
            }
            System.out.println(names);
        }
    }
}
