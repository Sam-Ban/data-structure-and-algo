package practice.tree.binarytree.problems.distancebetweentwonodes;

public class BinarySearchTree {
    Node root;
    public BinarySearchTree(){
        root=null;
    }

    int distanceFromRoot(Node root,int key){
        if(root.key==key)
            return 0;
        else if(key< root.key)
            return 1+distanceFromRoot(root.left,key);
        else
            return 1+distanceFromRoot(root.right,key);
    }

    int distanceBetweenTwoNodes(Node root,int key1,int key2){
        if(root==null)
            return 0;
        if(root.key>key1 && root.key>key2)
            return distanceBetweenTwoNodes(root.left,key1,key2);
        if(root.key<key1 && root.key<key2)
            return distanceBetweenTwoNodes(root.right,key1,key2);
        if(root.key>=key1 && root.key<=key2)
            return distanceFromRoot(root,key1) + distanceFromRoot(root,key2);
        return 0;
    }
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.root= new Node(10);
        bst.root.left = new Node(5);
        bst.root.left.left=new Node(2);
        bst.root.left.right=new Node(7);
        bst.root.right=new Node(15);
        bst.root.right.left=new Node(12);
        bst.root.right.right=new Node(20);

        System.out.println(bst.distanceFromRoot(bst.root,20));
        System.out.println(bst.distanceBetweenTwoNodes(bst.root,2,20));
        System.out.println(bst.distanceBetweenTwoNodes(bst.root,2,7));
        System.out.println(bst.distanceBetweenTwoNodes(bst.root,12,20));
    }
}
