class Node {
    int data;
    Node prev;
    Node next;
    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

/**
 * Linked List
 * Date   : 17-02-2024
 * Author : Lutfi
 */
public class LinkedList {

    private static Node head;

    private void push(int data) {
        Node newData = new Node(data);
    
        // Check if the list is empty
        if (head == null) {
            head = newData;
            return;
        }

        // Traverse to the last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // Set the next of the last node to the new node
        last.next = newData;
    }

    private int size() {
        Node c = head;
        int total = 0;

        while (c != null) {
            c = c.next;
            total++;
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;

        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }

        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.push(1);
        l.push(2);
        l.push(21);
        l.push(23);

        System.out.println(l);
        System.out.println(l.size());
    }
}