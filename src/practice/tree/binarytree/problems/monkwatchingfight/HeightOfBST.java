package practice.tree.binarytree.problems.monkwatchingfight;

import java.util.HashSet;
import java.util.Scanner;

/*
Once Monk was watching a fight between an array and a tree, of being better. Tree got frustrated and converted that array into a Binary Search Tree by inserting the elements as nodes in BST, processing elements in the given order in the array. Now Monk wants to know the height of the created Binary Search Tree.

Help Monk for the same.

Note:

1) In Binary Search Tree, the left sub-tree contains only nodes with values less than or equal to the parent node; the right sub-tree contains only nodes with values greater than the parent node.

2) Binary Search Tree with one node, has height equal to 1.

Input Format :

The first line will consist of 1 integer N, denoting the number of elements in the array.
In next line, there will be N space separated integers,  , where , denoting the elements of array.

Output Format

Print the height of the created Binary Search Tree.


SAMPLE INPUT
4
2 1 3 4
SAMPLE OUTPUT
3
Explanation
.

Insert 2. It becomes root of the tree.
Insert 1. It becomes left child of 2.
Insert 3. It becomes right child of 2.
Insert 4. It becomes right child of 3.
Final height of tree = 3.
 */

class Node {
    int key;
    Node left,right;

    public Node(int key){
        this.key=key;
        left=right=null;
    }
}

public class HeightOfBST {

    Node root;
    public HeightOfBST(){
        root =null;
    }

    public void add(int key){
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (key <= current.key) {
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

    public int getHeight(Node root){
        if(root==null)
            return 0;
        return 1+ Math.max(getHeight(root.left),getHeight(root.right));

    }

    public static void main(String[] args){
        HashSet<Long> hs = new HashSet<>();

                Scanner s = new Scanner(System.in);

        int n = s.nextInt();
       // int[] arr = new int[n];
        HeightOfBST bst = new HeightOfBST();
        for(int i=0;i<n;i++) {
            bst.add(s.nextInt());
        }
        System.out.println(bst.getHeight(bst.root));
    }
}
