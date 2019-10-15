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

    public void add(int elem) {
        if (first == null) {
            first = new Node(elem,null);
        } else {
            Node current = first;
            while (current.next != null) {
                // is it the last node?
                current = current.next;
            }
            Node last = current;
            last.next = new Node(elem, null);
        }
    }
    int get(int index) {
        // 2 cases
        if (first == null) { // list is empty
            // case 1: zero elements
            throw new IndexOutOfBoundsException("list is empty");
        } else {
            // case 2: at least one element
            int counter = 0;
            Node current = first;
            // can use "next" field
            while (current.next != null && counter < index) {
                current = current.next;
                counter++;
            }
            if (counter == index) {
                return current.elem;
            } else {
                throw new IndexOutOfBoundsException("index out of bounds");
            }

        }
    }
    public int size() {
        return 0;

    }

    public boolean isEmpty() {
         if(first == null) {
            return true;
        }
        return false;
    }
}
