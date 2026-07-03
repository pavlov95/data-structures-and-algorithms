package linkedList.doublyLinkedList;

public class DoublyLinkedList {
    public static class DoublyNode {
        int value;
        DoublyNode next;
        DoublyNode prev;
    }
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public DoublyNode create(int nodeValue) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;

        head = newNode;
        tail = newNode;
        size = 1;

        return head;
    }

    public void insert(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;

        if (head == null) {
            create(nodeValue);
            return;
        }

        if (location <= 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (location >= size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode current = head;

            for (int i = 0; i < location - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        size++;
    }

    public String traverseForward() {
        StringBuilder sb = new StringBuilder();
        DoublyNode current = head;

        while (current != null) {
            sb.append(current.value);

            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }

        return sb.toString();
    }

    public String traverseBackward() {
        StringBuilder sb = new StringBuilder();
        DoublyNode current = tail;

        while (current != null) {
            sb.append(current.value);

            if (current.prev != null) {
                sb.append(" <- ");
            }

            current = current.prev;
        }

        return sb.toString();
    }

    public int indexOf(int nodeValue) {
        DoublyNode current = head;

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

        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        if (location == 0) {
            head = head.next;
            head.prev = null;
        } else if (location == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            DoublyNode current = head;

            for (int i = 0; i < location; i++) {
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
    }

    public void clear() {
        DoublyNode current = head;

        while (current != null) {
            DoublyNode nextNode = current.next;
            current.prev = null;
            current.next = null;
            current = nextNode;
        }

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
