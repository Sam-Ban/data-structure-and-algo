package practice.tree.binarytree;

public class MinValueInBST {
    Node root;

    private Node addNodeRecursively(Node current, int key) {
        if (current == null)
            return new Node(key);

        if (key <= current.key)
            current.left = addNodeRecursively(current.left, key);
        else if (key > current.key)
            current.right = addNodeRecursively(current.right, key);
        else return current;

        return current;
    }

    public Node add(int key) {
        root = addNodeRecursively(root, key);
        return root;
    }

    private int findMinValue(Node node){
        while(node.left!=null)
            node=node.left;

        return node.key;
    }

    private int findMaxValueRecursive(Node node){
        if(node.right==null)
            return node.key;
        else {
            node = node.right;
            return findMaxValueRecursive(node);
        }
    }
    public static void main(String[] args){
        MinValueInBST mbst = new MinValueInBST();

        Node root = mbst.add(12);
        mbst.add(9);
        mbst.add(16);
        mbst.add(5);
        mbst.add(10);
        mbst.add(13);
        mbst.add(20);//12,9,16,5,10,13,20

       System.out.println("Min value in the whole BST is : "+mbst.findMinValue(root));
       System.out.println("Max value in the whole BST is : "+mbst.findMaxValueRecursive(root));
    }
}
