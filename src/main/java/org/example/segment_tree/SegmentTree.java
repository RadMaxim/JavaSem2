package org.example.segment_tree;

import java.util.ArrayList;

public class SegmentTree {
    static int len = (int)(Math.pow(10, 5)*2);
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static {
        for (int i = 0; i <len ; i++) {
            arrayList.add(i);
        }
    }
    private ArrayList<Integer> tree;
    private ArrayList<Integer> array;
    private int n;

    public SegmentTree(ArrayList<Integer> arrayList) {
        this.array = arrayList;
        this.n = arrayList.size();
        this.tree = new ArrayList<>();

        // Инициализация дерева с нулями
        for (int i = 0; i < 4 * n; i++) {
            tree.add(0);
        }

        buildTree(0, 0, n - 1);
    }

    // Построение дерева
    private void buildTree(int node, int start, int end) {
        if (start == end) {
            // Листовая вершина
            tree.set(node, array.get(start));
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            buildTree(leftChild, start, mid);
            buildTree(rightChild, mid + 1, end);

            // Обновляем текущий узел (например, суммой двух детей)
            tree.set(node, tree.get(leftChild) + tree.get(rightChild));
        }
    }

    // Запрос суммы на подотрезке [L, R]
    public long query(int L, int R) {
        return query(0, 0, n - 1, L, R);
    }

    private long query(int node, int start, int end, int L, int R) {
        if (R < start || L > end) {
            // Полностью вне диапазона
            return 0; // Для суммы; для минимума или максимума используйте соответствующее значение
        }
        if (L <= start && end <= R) {
            // Полностью внутри диапазона
            return tree.get(node);
        }
        // Частично в диапазоне
        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        long leftSum = query(leftChild, start, mid, L, R);
        long rightSum = query(rightChild, mid + 1, end, L, R);

        return leftSum + rightSum;
    }

    // Обновление элемента в массиве
    public void update(int idx, int value) {
        update(0, 0, n - 1, idx, value);
    }

    private void update(int node, int start, int end, int idx, int value) {
        if (start == end) {
            // Обновляем массив и дерево
            array.set(idx, value);
            tree.set(node, value);
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            if (idx <= mid) {
                update(leftChild, start, mid, idx, value);
            } else {
                update(rightChild, mid + 1, end, idx, value);
            }

            // Обновляем текущий узел
            tree.set(node, tree.get(leftChild) + tree.get(rightChild));
        }
    }

    public static void main(String[] args) {

        SegmentTree segmentTree = new SegmentTree(arrayList);
        long t1 = System.currentTimeMillis();
        System.out.println("Сумма отрезка : " + segmentTree.query(0, (int) len));
        long t2 = System.currentTimeMillis();// 6
        sumOfNumbers(arrayList);
        long t3 = System.currentTimeMillis();
        System.out.println("Segment tree"+(t2-t1));
        System.out.println("Line: "+(t3-t2));
//        segmentTree.update(1, 10);
//        System.out.println("Сумма отрезка [1, 3] после обновления: " + segmentTree.query(1, 3)); // 16
    }
    public static void sumOfNumbers(ArrayList<Integer> arrayList){
        long buf = 0;
        for (Integer integer : arrayList) {
            buf += integer;
        }
        System.out.println(buf);
    }
}
