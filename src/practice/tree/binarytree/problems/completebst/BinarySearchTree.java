package practice.tree.binarytree.problems.completebst;

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    /*private Node add(Node current, int key) {
        if (current == null)
            return new Node(key);

        else if (key < current.key) {
            current.left = add(current.left, key);
        } else if (key > current.key) {
            current.right = add(current.right, key);
        } else {
            // value already exists
            return current;
        }
        return current;
    } */

  /*  public void addNode(int key) {
        root = add(root, key);
    } */

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

    public boolean find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key)
                return true;
            else if (key < current.key)
                current = current.left;
            else if (key > current.key)
                current = current.right;
            else return false;
        }
        return false;
    }

    public boolean delete(int key) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while (current.key != key) {
            parent = current;
            if (current.key > key) {
                isLeftChild = true;
                current = current.left;

            } else {
                current = current.right;
            }
            if (current == null)
                return false;
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if (current.left == null & current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild == true) {
                parent.left = null;
            } else
                parent.right = null;
        }
        //Case 2 : if node to be deleted has only one child
        else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        //case 3 : If Node to be deleted has two children(both left and right subtree is there)
       /*Find The Successor:
       Successor is the node which will replace the deleted node. Now the question is to how to find it and where to find it.
       Successor is the smaller node in the right sub tree of the node to be deleted
       */
        else if (current.left != null && current.right != null) {
            //now we have found the minimum element in the right sub tree
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleleNode) {
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.

        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    //Inorder traversal
    public void displayInorder(Node root) {
        if (root != null) {
            displayInorder(root.left);
            System.out.print(" " + root.key);
            displayInorder(root.right);
        }
    }

    public void displayPreorder(Node root) {
        if (root != null) {
            System.out.print(" "+root.key);
            displayPreorder(root.left);
            displayPreorder(root.right);
        }
    }

    public void displayPostorder(Node root) {

        if (root != null) {
            displayPreorder(root.left);
            displayPreorder(root.right);
            System.out.print(" "+root.key);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(6);
        bst.add(12);
        bst.add(5);
        bst.add(8);
        bst.add(11);
        bst.add(16);
        bst.add(15);
        bst.add(14);
        bst.add(17);

        System.out.println(bst.root.key);
        System.out.println(bst.find(12));
       // System.out.println(bst.delete(11));
        bst.displayInorder(bst.root);
        System.out.println();
        bst.displayPreorder(bst.root);
        System.out.println();
        bst.displayPostorder(bst.root);
    }
}
