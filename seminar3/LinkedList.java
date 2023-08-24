package Algorithms.seminar3;

public class LinkedList {
    public Node head;
    public Node tail;

    public class Node {
        public int value;
        public Node next;

        public void addFirst(int value){
            Node node= new Node(value);
            if (head!=null) {
                head.next = node;
            }
            head = node;
        }

        private void deleteFromBeginning(){
            if (head!=null) {
                head = head.next;
            }
        }

        public boolean isContains(int target) {
            return contains(target) != null?true:false;
        }

        public Node contains(int target){
            while (head!=null){
                if(head.value == target){
                    return head;
                }
                head = head.next;
            }
            return null;
        }
        public Node(int value) {
            this.value =value;
            this.next = null;
        }
    }
}
