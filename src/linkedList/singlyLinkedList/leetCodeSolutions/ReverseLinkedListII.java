package linkedList.singlyLinkedList.leetCodeSolutions;

//92. Reverse Linked List II

//Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the
//list from position left to position right, and return the reversed list.


public class ReverseLinkedListII {

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode previous = dummy;

        //Move previous to the node before position left
        for (int i = 1; i < left; i++) {
            previous = previous.next;
        }

        ListNode current = previous.next;

        //Move each following node to the front of the reversed section
        for (int i = 0; i < right - left; i++) {
            ListNode nodeToMove = current.next;

            current.next = nodeToMove.next;
            nodeToMove.next = previous.next;
            previous.next = nodeToMove;
        }

        return dummy.next;
    }
}