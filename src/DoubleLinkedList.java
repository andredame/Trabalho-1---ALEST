public class DoubleLinkedList {

    private Node head;
    private Node tail;

    private class Node {
        private String data;
        private Node prev;
        private Node next;
 
        // Constructor to create a new node
        // next and prev is by default initialized as null
        private Node(String d) {
            data = d; 
            this.next = null;
            this.prev = null;
        }
        public String getData() {
            return data;
        }

    
}
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }
    public void insertion(String val){
        Node newNode = new Node(val);
        if (this.head == null) {
           this.head = newNode;
           this.tail = newNode;
        } else {
          this.tail.next = newNode;
          newNode.prev = this.tail;
          this.tail = newNode;
        }
    }
    public void printForward() {
        Node current = this.head;
        System.out.print("Doubly Linked List (Forward): ");
        while (current != null) {
            System.out.print(current.data + "");
            current = current.next;
        }
        System.out.println();
    }
    
    public Node getHead() {
        return head;
    }
    public Node getTail() {
        return tail;
    }
    public void printHead() {
        System.out.println(head.getData());
    }
    public void printTail() {
        System.out.println(tail.getData());
    }
}
