package practice.tree.binarytree.problems.bfstraversal;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    //Time complexity O(n) : where n is the number of nodes in a tree
    public void levelOrderQueue(Node root){
        Queue q = new LinkedList();
        int levelNode =0;
        if(root==null) return;
        q.add(root);
        while(!q.isEmpty()){
            levelNode = q.size();
            while(levelNode>0){
                Node n = (Node)q.remove();
                System.out.print(" " + n.key);
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
                levelNode--;
            }
            System.out.println("");
        }
    }

    public static void main (String[] args) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        LevelOrderTraversal i  = new LevelOrderTraversal();
        i.levelOrderQueue(root);
    }
}
