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
        int counter = 0;
        Node current = first;
        if(current == null){
            return 0;
        } else {
            while(current.next != null){
                current = current.next;
                counter = counter + 1;
            }
            //this is off by one error
            return counter+1;
        }

    }
    public boolean isEmpty() {
         if(first == null) {
            return true;
        }
        return false;
    }

    public void printLL() {
        if (this.first == null) {
            return;
        }
        //print all nodes
        Node tempNode = this.first;
        while (tempNode != null) {
            System.out.print(tempNode.elem+ "->");
            tempNode = tempNode.next;
        }
        System.out.println("NULL");
    }

    public int indexOf(int elem) {
        int index = 0;
        Node current = first;
        if (current == null) {
            return -1;
        }
        while(current.next != null && current.elem != elem){
            current = current.next;
            index = index + 1;
        }
        if(current.elem == elem)
            return index;
        return -1;
    }
}


