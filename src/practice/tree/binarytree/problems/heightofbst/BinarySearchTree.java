package practice.tree.binarytree.problems.heightofbst;

import practice.problems.recursion.BinarySearch;

public class BinarySearchTree {
    Node root;
    public BinarySearchTree(){
        root=null;
    }

    //Time complexity O(n)
    int height(Node root){
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(5);
        bst.root.left = new Node(10);
        bst.root.right = new Node(15);
        bst.root.left.left = new Node(20);
        bst.root.left.right = new Node(25);
        bst.root.right.left = new Node(30);
        bst.root.right.right = new Node(35);

        System.out.println(bst.height(bst.root));
    }
}
