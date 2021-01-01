package practice.tree.binarytree.problems.yatinplayspubg;

import java.util.Scanner;

class Node {
    int key;
    Node left,right;

    public Node(int key){
        this.key=key;
        left=right=null;
    }
}
public class BinarySearchTree {
    Node root;
    public BinarySearchTree(){
        root = null;
    }

    void add(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
       Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (key < current.key) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    int getMaxEnemies(Node root){
        if(root==null)
            return 0;
        return 1+Math.max(getMaxEnemies(root.left),getMaxEnemies(root.right));
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T>0) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = s.nextInt();
            BinarySearchTree bst = new BinarySearchTree();
            // bst.root=bst.add(arr[0]);
            for (int i = 0; i < n; i++)
                bst.add(arr[i]);
            System.out.println(bst.getMaxEnemies(bst.root));
            T--;
        }
    }
}
