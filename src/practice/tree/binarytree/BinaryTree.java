package practice.tree.binarytree;

public class BinaryTree {

    // Root of Binary Tree
    Node root;

    BinaryTree()
    {
        root = null;
    }

    void printInorder(Node node) //left--root--right
    {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
    void printPostorder(Node node) //left--right--root
    {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }

    void printPreorder(Node node)  //root--left--right
    {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printPostorder()  {     printPostorder(root);  }
    void printInorder()    {     printInorder(root);   }
    void printPreorder()   {     printPreorder(root);  }

    private Node addRecursive(Node current, int key) {
        if (current == null) {
            return new Node(key);
        }

        if (key < current.key) {
            current.left = addRecursive(current.left, key);
        } else if (key > current.key) {
            current.right = addRecursive(current.right, key);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int key) {
        root = addRecursive(root, key);
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /*tree.add(12);
        tree.add(9);
        tree.add(16);
        tree.add(5);
        tree.add(10);
        tree.add(13);
        tree.add(20); */


        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }
}
