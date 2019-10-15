package exercises;

class Node {
    int elem;
    Node next;
    // Constructor
    Node(int elem,Node next)
    {
        this.elem = elem;
        this.next = null;
    }
}
public class LinkedList {
    Node first = null;

    public void add(int elem){
        if (first == null){
            Node n = new Node(elem,null);
            first = n;
        }else{
            Node current = first;
            while (current.next != null) {
                // is it the last node?
                current = current.next;
        }
        Node last = current;
        last.next = new Node(elem, null);
    }
    }
}
