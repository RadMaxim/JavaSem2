package org.example;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class UseTreeBinary {
    static int size = (int) Math.pow(10,7);
    static Tree tree = new Tree();
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static {
        arrayList = CreateArrayList.createArrayList(size);
        tree.insertNode(0);
        for (int i = 1; i <size; i++) {
            int num = CreateArrayList.random.nextInt(-1000,1000);

            tree.insertNode(num);
        }
    }
    public static void main(String[] args) {

        System.out.println("____________________________________________");
        System.out.println(ClassLayout.parseInstance(arrayList).toPrintable());
        System.out.println(ClassLayout.parseInstance(tree).toPrintable());
        System.out.println("Look for value");
        double t1 = System.currentTimeMillis();
        int val = tree.findNodeByValue(-10).getValue();
        double t2 = System.currentTimeMillis();
        int arrayVal = FindElemArray.findElem(arrayList, arrayList.get(arrayList.size()-1));
        double t3 = System.currentTimeMillis();
        System.out.println("Time of ArrayList: "+(t3-t2));
        System.out.println("Time of Tree: "+(t2-t1));

    }

}
