package linkedList.singlyLinkedList.leetCodeSolutions;

//160. Intersection of Two Linked Lists

//Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
//If the two linked lists have no intersection at all, return null.
//For example, the following two linked lists begin to intersect at node c1:

//The test cases are generated such that there are no cycles anywhere in the entire linked structure.

//Note that the linked lists must retain their original structure after the function returns.

public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        //Each pointer traverses both lists.
        //This compensates for any difference in list lengths.
        while (pointerA != pointerB) {
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }

        // Returns the intersection node or null if the lists do not intersect.
        return pointerA;
    }
}
