package practice.tree.binarytree.problems.monkandcursedtree;

import java.util.Scanner;

/*
Monk has an array A having N distinct integers and a Binary Search Tree which is initially empty. He inserts all the elements of the array from index 1 to N in the BST in the order given in the array. But wait! The tree so formed turns out to be cursed. Monk is having some weird experiences since he made that tree.

So, now to stop all that, Monk has two options, to destroy the BST or to pray to God and ask for a solution. Now since Monk has to use this BST in a Code Monk Challenge, he cannot destroy it. So he prays to God.

God answer his prayers and sends an angel named Micro. Now, Micro asks Monk to find something. He tells him two values, X and Y, present in the BST and ask him to find the maximum value that lie in the path between node having value X and node having value Y. (including X and Y ).

Now since, Monk is very afraid of that tree he asks for your help.

Input:
First line consists of a single integer denoting N.
Second line consists of N space separated integers denoting the array A.
Third line consists of two space separated integers denoting X and Y.

Output:
Print the maximum value that lie in the path from node having value X and node having value Y in a new line.

Constraints:


It is ensured that values X and Y are present in the array.

SAMPLE INPUT:
5
4 7 8 6 3
3 7

SAMPLE OUTPUT
7
 */
class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
        left = right = null;
    }
}

public class BST {
    Node root;

    public BST() {
        root = null;
    }

    public void add(int key) {
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

    int findMaxFromRoot(Node root, int key1) {
        if (root.key == key1)
            return key1;
        if (root.key > key1)
            return root.key;
        else return findMaxFromRoot(root.right, key1);
    }

    // Time complexity : O(h) where h is height of the tree
    int findMaxInPath(Node root, int key1, int key2) {
        if (root == null)
            return -1;
        if (root.key > key1 && root.key > key2)
            return findMaxInPath(root.left, key1, key2);
        if (root.key < key1 && root.key < key2)
            return findMaxInPath(root.right, key1, key2);
        if (root.key >= key1 && root.key <= key2)
            return Math.max(findMaxFromRoot(root, key1), findMaxFromRoot(root, key2));
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        int key1 = s.nextInt();
        int key2 = s.nextInt();
        BST bst = new BST();
        for (int i = 0; i < n; i++)
            bst.add(arr[i]);

        if (key1 > key2) {
            int temp = key1;
            key1 = key2;
            key2 = temp;
        }

        System.out.println(bst.findMaxInPath(bst.root, key1, key2));

    }

}
