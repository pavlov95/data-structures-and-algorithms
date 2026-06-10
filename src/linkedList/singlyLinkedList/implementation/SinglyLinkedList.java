package linkedList.singlyLinkedList.implementation;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    //Time complexity: O(1)
    //Space complexity: O(1)
    public Node create(int nodeValue) {
        Node node = new Node();
        node.setValue(nodeValue);
        node.setNext(null);

        head = node;
        tail = node;
        size = 1;

        return head;
    }

    //Insert Method SinglyLinkedList
    //Time complexity: O(n)
    //Space complexity: O(1)
    public void insert(int nodeValue, int location) {
        Node node = new Node();
        node.setValue(nodeValue);
        if (head == null) {
            create(nodeValue);
            return;
        } else if (location == 0) {
            node.setNext(head);
            head = node;
        } else if (location >= size) {
            node.setNext(null);
            tail.setNext(node);
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.getNext();
                index++;
            }
            Node nextNode = tempNode.getNext();
            tempNode.setNext(node);
            node.setNext(nextNode);
        }
        size++;
    }

    //SinglyLinkedList Traversal
    //Time complexity: O(n)
    //Space complexity: O(1)
    public String traverse() {
        if (head == null) {
            throw new IllegalArgumentException("Singly Linked List does not exist");
        }
        StringBuilder sb = new StringBuilder();
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            sb.append(tempNode.getValue()).append(" ");

            tempNode = tempNode.getNext();
        }

        return sb.toString();
    }

    //Search for a node
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int indexOf(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.getValue() == nodeValue) {

                    return i;
                }
                tempNode = tempNode.getNext();
            }
        }

        return -1;
    }

    //Deleting a node from SinglyLinkedList
    //Time complexity: O(n)
    //Space complexity: O(1)
    public void delete(int location) {
        if (head == null) {
            return;
        }

        if (location < 0 || location >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + location);
        }

        if (location == 0) {
            head = head.getNext();
            size--;
            if (size == 0) {
                tail = null;
            }
            return;
        }

        Node previousNode = head;

        for (int i = 0; i < location - 1; i++) {
            previousNode = previousNode.getNext();
        }

        Node nodeToDelete = previousNode.getNext();
        previousNode.setNext(nodeToDelete.getNext());

        if (nodeToDelete == tail) {
            tail = previousNode;
        }

        size--;
    }

    //Delete Entire SinglyLinkedList
    //Time complexity: O(1)
    //Space complexity: O(1)
    public void deleteSLL() {
        head = null;
        tail = null;
        size = 0;
    }
}
