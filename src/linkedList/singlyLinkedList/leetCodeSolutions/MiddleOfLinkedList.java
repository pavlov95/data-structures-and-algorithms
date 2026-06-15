package linkedList.singlyLinkedList.leetCodeSolutions;

//876. Middle of the Linked List

//Given the head of a singly linked list, return the middle node of the linked list.
//If there are two middle nodes, return the second middle node.

public class MiddleOfLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //Time complexity: O(n)
    //Space complexity: O(1)
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        int size = 0;
        ListNode current = head;

        //Find the size of the LinkedList/ListNode
        while (current != null) {
            size++;
            current = current.next;
        }
        //Start from head again
        current = head;

        //Stop at the middle
        for (int i = 0; i < size / 2; i++) {
            current = current.next;
        }

        return current;
    }


}
