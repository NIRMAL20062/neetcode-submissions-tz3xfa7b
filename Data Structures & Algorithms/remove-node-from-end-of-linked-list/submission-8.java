/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode curr = head;
    int len = 0;

    while (curr != null) {
        len++;
        curr = curr.next;
    }

    // Edge case: removing the head node itself
    if (n == len) return head.next;

    // Walk to the node just BEFORE the one to delete
    curr = head;
    for (int i = 0; i < len - n - 1; i++) {
        curr = curr.next;
    }

    // Skip the target node
    curr.next = curr.next.next;

    return head;
}
}
