package practice.linkedlist;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}


public class DetectAndRemoveLoop {
    Node head;


    void detectAndRemoveLoop(Node node){
        Node slow=node;
        Node fast=node;

        while (slow != null && fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow.data==fast.data){
                System.out.println("Loop Detected");
                //Working on removal of the loop
                slow = head;
                while(slow.next.data!=fast.next.data){
                    slow=slow.next;
                    fast=fast.next;
                }
                fast.next=null;
            }
        }
    }

    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public static void main(String... args){
        DetectAndRemoveLoop ds = new DetectAndRemoveLoop();
        ds.head = new Node(50);
        ds.head.next=new Node(20);
        ds.head.next.next=new Node(15);
        ds.head.next.next.next=new Node(4);
        ds.head.next.next.next.next=new Node(10);

        ds.head.next.next.next.next.next = ds.head.next.next;
        ds.detectAndRemoveLoop(ds.head);
        ds.printList(ds.head);

    }
}
