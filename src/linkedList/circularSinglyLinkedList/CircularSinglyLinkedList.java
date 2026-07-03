package linkedList.circularSinglyLinkedList;

public class CircularSinglyLinkedList {
     public static class Node {
        public int value;
        public Node next;
    }


    private Node head;
    private Node tail;
    private int size;

    public Node create(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        node.next = node;

        head = node;
        tail = node;
        size = 1;

        return head;
    }

    public void insert(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {
            create(nodeValue);
            return;
        }

        if (location <= 0) {
            node.next = head;
            head = node;
            tail.next = head;
        } else if (location >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;
        } else {
            Node current = head;

            for (int i = 0; i < location - 1; i++) {
                current = current.next;
            }

            node.next = current.next;
            current.next = node;
        }

        size++;
    }

    public String traverse() {
        if (head == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Node current = head;

        for (int i = 0; i < size; i++) {
            sb.append(current.value);

            if (i < size - 1) {
                sb.append(" -> ");
            }

            current = current.next;
        }

        return sb.toString();
    }

    public int indexOf(int nodeValue) {
        if (head == null) {
            return -1;
        }

        Node current = head;

        for (int i = 0; i < size; i++) {
            if (current.value == nodeValue) {
                return i;
            }

            current = current.next;
        }

        return -1;
    }

    public void delete(int location) {
        if (head == null) {
            return;
        }

        if (location < 0 || location >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + location);
        }

        if (location == 0) {
            if (size == 1) {
                head.next = null;
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }

            size--;
            return;
        }

        Node previousNode = head;

        for (int i = 0; i < location - 1; i++) {
            previousNode = previousNode.next;
        }

        Node nodeToDelete = previousNode.next;
        previousNode.next = nodeToDelete.next;

        if (nodeToDelete == tail) {
            tail = previousNode;
        }

        size--;
    }

    public void clear() {
        if (head == null) {
            return;
        }

        tail.next = null;
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
