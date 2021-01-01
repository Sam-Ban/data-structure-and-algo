package practice.tree.binarytree.problems.determinebst;

/*
Program to determine whether a binary tree is a binary search tree or not(using min & max way)
 */
public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }
//Worst case time complexity : O(n)
    public boolean isBST(Node root, int max, int min) {
        if (root != null) {
            if (root.key > max || root.key < min) {
                return false;
            }
            return isBST(root.left, root.key, min) && isBST(root.right, max, root.key);
        } else return true;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(10);
        bst.root.left = new Node(6);
        bst.root.left.left = new Node(5);
        bst.root.left.right = new Node(8);
        bst.root.right = new Node(15);
        // bst.root.right.left = new Node(11);
        bst.root.right.left = new Node(19);
        bst.root.right.right = new Node(16);
        bst.root.right.right.right = new Node(17);

        System.out.println(bst.isBST(bst.root, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}
