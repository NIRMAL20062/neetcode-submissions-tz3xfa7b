class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Count total nodes
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Edge case: remove head
        int target = count - n;
        if (target == 0) {
            return head.next;
        }

        // Step 2: Traverse to node just before target
        curr = head;
        int count2 = 0;
        while (curr != null) {
            if (count2 == target - 1) {
                break;
            }
            count2++;
            curr = curr.next;
        }

        // Remove the node
        if (curr.next.next == null) {   // last node
            curr.next = null;
        } else {                         // in-between node
            curr.next = curr.next.next;
        }

        return head;
    }
}