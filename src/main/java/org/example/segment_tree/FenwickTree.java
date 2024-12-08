package org.example.segment_tree;

import java.util.ArrayList;

public class FenwickTree {
    private ArrayList<Long> fenwickTree;
    private int n;
    private static ArrayList<Integer> arrayList = new ArrayList<>();

    static {
        for (int i = 0; i < Math.pow(10, 4); i++) {
            arrayList.add(i);
        }
    }

    public FenwickTree(ArrayList<Integer> array) {
        this.n = array.size();
        this.fenwickTree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            fenwickTree.add(0L);
        }
        for (int i = 0; i < n; i++) {
            add(i, array.get(i));
        }
    }

    public void add(int idx, int value) {
        idx++; // Переход к 1-индексации
        while (idx <= n) {
            fenwickTree.set(idx, fenwickTree.get(idx) + value);
            idx += idx & -idx; // Переход к следующему индексу
        }
    }

    public long sum(int idx) {
        idx++; // Переход к 1-индексации
        long result = 0;
        while (idx > 0) {
            result += fenwickTree.get(idx);
            idx -= idx & -idx;
        }
        return result;
    }

    public long rangeSum(int left, int right) {
        return sum(right) - (left > 0 ? sum(left - 1) : 0);
    }

    public static void main(String[] args) {
        FenwickTree fenwickTree = new FenwickTree(arrayList);
        long t1 = System.currentTimeMillis();
        long sumFenwick = fenwickTree.rangeSum(0, arrayList.size() - 1);
        long t2 = System.currentTimeMillis();
        System.out.println("Сумма отрезка [0, " + (arrayList.size() - 1) + "] через FenwickTree: " + sumFenwick);
        System.out.println("Время выполнения FenwickTree: " + (t2 - t1) + " мс");
        long t3 = System.currentTimeMillis();
        long sumDirect = sumOfNumbers(arrayList);
        long t4 = System.currentTimeMillis();
        System.out.println("Сумма отрезка [0, " + (arrayList.size() - 1) + "] через прямую сумму: " + sumDirect);
        System.out.println("Время выполнения прямого суммирования: " + (t4 - t3) + " мс");
    }

    public static long sumOfNumbers(ArrayList<Integer> arrayList) {
        long buf = 0;
        for (int num : arrayList) {
            buf += num;
        }
        return buf;
    }
}
