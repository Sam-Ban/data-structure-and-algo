package practice.tree.binarytree.problems.greatersumtree;

public class BSTtoGreaterSumTree {
    public static int sum = 0;



    public  void inorderTraverse(Node root){
        if(root!=null){
            inorderTraverse(root.left);
            System.out.print(" "+root.key);
            inorderTraverse(root.right);
        }
    }

    //Time complexity : O(n) as each node visited only once
    public void greaterTree(Node root){
        if(root!=null){
            //visit the right node first
            greaterTree(root.right);
            //store the node value in temp
            int temp = root.key;
            //update the sum, sum till previous visited node
            root.key = sum;
            //update the sum for the next node
            sum = sum + temp;
            greaterTree(root.left);
        }else return;
    }


    public static void main(String[] args){
        Node root = new Node(10);
        root.left=new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right=new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        BSTtoGreaterSumTree b = new BSTtoGreaterSumTree();
        b.inorderTraverse(root);
        System.out.println();
        b.greaterTree(root);
        System.out.println("After converting GST from BST : ");
        b.inorderTraverse(root);
    }
}

