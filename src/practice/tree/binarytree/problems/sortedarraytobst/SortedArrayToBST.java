package practice.tree.binarytree.problems.sortedarraytobst;

public class SortedArrayToBST {
    Node root;
    public SortedArrayToBST(){
        root=null;
    }

    Node convertBST(int[] arr, int low,int high){
        if(low>high)
            return null;
        int mid = (low+high)/2;
        Node root = new Node(arr[mid]);
        root.left = convertBST(arr,low,mid-1);
        root.right = convertBST(arr,mid+1,high);
        return root;
    }
    //inorder traversal : root-left-right
    void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(" "+root.key);
            display(root.right);
        }
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        SortedArrayToBST sbst = new SortedArrayToBST();
        Node x = sbst.convertBST(arr,0,arr.length-1);
        sbst.display(x);
    }
}
