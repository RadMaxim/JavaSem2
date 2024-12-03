package org.example;

import java.util.Random;

public class UseTreeBinary {
    static Random random = new Random();
    public static void main(String[] args) {
        BinaryTree.Tree tree = new BinaryTree.Tree();
        for (int i = 0; i <100 ; i++) {
            tree.insertNode(random.nextInt(100));
        }
        tree.printTree();

    }
}
