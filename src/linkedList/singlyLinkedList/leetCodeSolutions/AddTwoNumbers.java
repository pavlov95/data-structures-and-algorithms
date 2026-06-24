package linkedList.singlyLinkedList.leetCodeSolutions;


public class AddTwoNumbers {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Dummy node simplifies construction of the result list
        ListNode dummy = new ListNode(0);

        //Points to the last node in the result list
        ListNode current = dummy;

        int carry = 0;
        //Continue until either list has digits left or there is a remaining carry.
        while (l1 != null || l2 != null || carry != 0) {
            int firstDigit = l1 != null ? l1.val : 0;
            int secondDigit = l2 != null ? l2.val : 0;

            int sum = firstDigit + secondDigit + carry;

            carry = sum / 10;
            int digit = sum % 10;

            current.next = new ListNode(digit);
            current = current.next;

            //Move through the first list
            if (l1 != null) {
                l1 = l1.next;
            }
            //Move through the second list
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }

}