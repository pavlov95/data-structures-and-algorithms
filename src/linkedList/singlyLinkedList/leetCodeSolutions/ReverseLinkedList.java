package linkedList.singlyLinkedList.leetCodeSolutions;

//206. Reverse Linked List



//Given the head of a singly linked list, reverse the list, and return the reversed list.
public class ReverseLinkedList {
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
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            //Create a new ListNode equal to the next
            ListNode next = current.next;

            //Reverse link
            current.next = previous;

            //Move previous ListNode forward
            previous = current;

            //Move current ListNode forward
            current = next;
        }

        return previous;
    }
}
