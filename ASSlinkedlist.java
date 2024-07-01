class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to add a node at the end of the list
    public void add( String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Left shift the linked list by n positions
    public void shiftListLeft(int n) {
        if (head == null || n <= 0) {
            return;
        }

        int length = getLength();
        n = n % length;

        if (n == 0) {
            return;
        }

        Node current = head;
        for (int i = 0; i < n - 1; i++) {
            current = current.next;
        }

        Node newHead = current.next;
        current.next = null;

        Node temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        head = newHead;
    }

    // Right shift the linked list by n positions
    public void shiftListRight(int n) {
        if (head == null || n <= 0) {
            return;
        }

        int length = getLength();
        n = n % length;

        if (n == 0) {
            return;
        }

        Node current = head;
        for (int i = 0; i < length - n - 1; i++) {
            current = current.next;
        }

        Node newHead = current.next;
        current.next = null;

        Node temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        head = newHead;
    }

    // Helper method to get the length of the linked list
    private int getLength() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("ABC");
        linkedList.add("DEF");
        linkedList.add("XYZ");
        linkedList.add("EFG");
        

        System.out.println("Original Linked List:");
        linkedList.display();

        int leftShifts = 2;
        linkedList.shiftListLeft(leftShifts);
        System.out.println("After Left Shifting " + leftShifts + " times:");
        linkedList.display();

        int rightShifts = 3;
        linkedList.shiftListRight(rightShifts);
        System.out.println("After Right Shifting " + rightShifts + " times:");
        linkedList.display();
    }
}
