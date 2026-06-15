package linkedList.singlyLinkedList.leetCodeSolutions;

//19. Remove Nth Node From End of List

//Given the head of a linked list, remove the nth node from the end of the list and return its head.

public class RemoveNthNodeFromEndOfList {


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        ListNode slow = dummy;
        ListNode fast = dummy;

        //Create a gap of n + 1 nodes
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }


}
