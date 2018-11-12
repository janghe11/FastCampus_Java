import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V data, Node<K,V> left, Node<K,V> right) {
            this.key   = key;
            this.data  = data;
            this.left  = left;
            this.right = right;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        void print() {
            System.out.println(data);
        }
    }


    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initCount = Integer.parseInt(br.readLine());
        StringBuilder[][] treeArray = new StringBuilder[initCount][3];

        for (int arrayCount = 0; arrayCount < initCount; arrayCount++) {
            char[] readChar = br.readLine().split(" ").toString().toCharArray();


        }


    }
}
