package Algorithms.seminar3;

public class LinkedList_myVersion {

    private Node head;
    private Node tail;

    public void addFirst(int value){
        Node node = new Node(value);
        if(head!= null) {
            node.next = head;
            head.previous = node;
        } else {
            tail = node;
        }
        head = node;
    }

    public void addLast(int value){
        Node node = new Node(value);
        if(head!=null){
            node.previous = tail;
            tail.next = node;
        } else {
            head=node;
        }
        tail = node;
    }

    public void deleteFirst(){
        if(head!=null){
            if(head.next!=null) {
                head = head.next;
                head.previous = null;
            } else {
                head=null;
                tail=null;
            }
        }
    }

    public void deleteLast(){
        if(tail!=null){
            if(tail.previous!=null){
                tail=tail.previous;
                tail.next=null;
            } else {
                tail=null;
                head=null;
            }
        }
    }


    public class Node{
        int value;
        public Node next;
        public Node previous;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }
}
