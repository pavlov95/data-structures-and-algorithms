package linkedList.singlyLinkedList.leetCodeSolutions;


//21. Merge Two Sorted Lists

//You are given the heads of two sorted linked lists list1 and list2.
//Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first
//two lists.
//Return the head of the merged linked list

public class MergeTwoSortedLists {


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

    //Time complexity: O(m + n)
    //Space complexity: O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Dummy node helps us build the merged list easily.
        //We will return dummy.next at the end, because dummy itself
        //is not part of the real answer.
        ListNode dummy = new ListNode(-1);

        //current always points to the last node in the merged list.
        ListNode current = dummy;

        //Continue while both lists still have nodes.
        while (list1 != null && list2 != null) {

            // Compare the current values from both lists.
            // Attach the smaller node to the merged list.
            if (list1.val <= list2.val) {
                current.next = list1;

                // Move list1 forward
                list1 = list1.next;
            } else {
                current.next = list2;

                //Move list2 forward
                list2 = list2.next;
            }

            //Move current forward to the newly added node.
            current = current.next;
        }

        //At this point, one list may still have remaining nodes.
        //Since both lists are already sorted, we can attach the rest directly.
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        //The merged list starts after the dummy node.
        return dummy.next;
    }
}
