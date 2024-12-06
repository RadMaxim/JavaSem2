package org.example.Junior1Sem14Les;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class Main {
    static TreeSet<String> treeSet;

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("data.txt"));
//        streamApi(lines);

//            cvtLength(lines);

           List<Integer> list =  cvtMap(lines);

        long t1 = System.currentTimeMillis();
        System.out.println("Sum: "+getSum(list));
        long t2 = System.currentTimeMillis();
        System.out.println("time: "+(t2-t1));

        System.out.println("Sum of API:"+getSumApi(list));
        long t3 = System.currentTimeMillis();
        System.out.println("time: "+(t3-t2));

        System.out.println("Sum of Parallel stream: "+getSumApiParallel(list));
        long t4 = System.currentTimeMillis();
        System.out.println("time: "+(t4-t3));
        
        filterArray(lines);
     
       
        usualWaySorted(lines);
      


    }
    public static void usualWaySorted(List<String> lines) throws IOException {
     
            System.out.println("List - Output data start - ");
            String start = scanner.next();
            long t1 = System.currentTimeMillis();
            List<String> filterData = new ArrayList<>();
            for (String elem:lines) {
                if (elem.startsWith(start)){
                    filterData.add(elem);
                }
            }
            long t2 = System.currentTimeMillis();
            System.out.println(filterData);
        System.out.println("Sorted using method usual method: "+(t2-t1));
         
        
    }
    public static void streamApiSorted(List<String> lines) throws IOException {
        while (true){
            System.out.println("Stream API - Output data start - ");
            String start = scanner.next();
            long t1 = System.currentTimeMillis();
            List<String> list = lines.stream().filter((elem) -> elem.startsWith(start)).toList();
            long t2 = System.currentTimeMillis();
            System.out.println(list);
            System.out.println("Time: "+(t2-t1));
            
        }
    }
    public static void cvtLength(List<String>list){
        List<Integer> integers = new ArrayList<>();
        for (String elem:list){
            integers.add(elem.length());
        }
        System.out.println(integers);
        System.out.println("Size of List: "+integers.size());
    }
    public static List<Integer> cvtMap(List<String>list){
        return list.stream().map(String::length).toList();

    }
    public static int getSum(List<Integer> list){
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
    public static int getSumApi(List<Integer> list){
        return list.stream().reduce(0,(buf,elem)->buf+elem);
    }
    public static int getSumApiParallel(List<Integer> list){
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);  // Задаем количество потоков
        int sumParallel = forkJoinPool.submit(() -> list.parallelStream().reduce(0,(buf,elem)->buf+elem)).join();
        return sumParallel;
    }
    public static void filterArray(List<String> list){
         treeSet = new TreeSet<>(list);
        System.out.println("TreeSet - Output data start - ");
        String start = scanner.next();
        String upperBound = start + Character.MAX_VALUE;
        long t4 =  System.currentTimeMillis();


        SortedSet<String> sortedSet = treeSet.subSet(start,upperBound);

        long t5 = System.currentTimeMillis();
        System.out.println(sortedSet);
        System.out.println("Sorted using method TreeSet: "+(t5-t4));
    }
}
