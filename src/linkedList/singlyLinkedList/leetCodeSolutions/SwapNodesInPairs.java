package linkedList.singlyLinkedList.leetCodeSolutions;

//24. Swap Nodes in Pairs
//Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
//modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
public class SwapNodesInPairs {

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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode previous = dummy;

        while (previous.next != null && previous.next.next != null) {
            ListNode first = previous.next;
            ListNode second = first.next;

            //Swap the two nodes
            first.next = second.next;
            second.next = first;
            previous.next = second;

            //Move to the next pair
            previous = first;
        }

        return dummy.next;
    }
}
