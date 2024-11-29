package org.example.Junior1Sem13Les;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PrefixTree {
    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("names.txt"));
        System.out.println(lines);
        TreeNode root = new TreeNode(' ');
        for (String line: lines) {
            root.insert(line);
        }
    }

    static class TreeNode {
        char value;
        List<TreeNode> children = new ArrayList<>();

        public TreeNode(char value) {
            this.value = value;
        }

        public void insert(String data) {
            if (data.isEmpty()) {
                return;
            }

            char c = data.charAt(0);
            TreeNode child = findNodeByChar(c);
            if (child == null) {
                child = new TreeNode(c);
                children.add(child);
            }
            child.insert(data.substring(1));
        }
        private TreeNode findNodeByChar(char c){
            if (children!=null){
                for (TreeNode node:children){
                    if (node.value==c){
                        return node;
                    }
                }
            }
            return null;
        }


    }

}
