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
    public ListNode mergeKLists(ListNode[] lists) {
        // Step 1: collect all values
        List<Integer> nodes = new ArrayList<>();

        for (ListNode list : lists) {
            while (list != null) {
                nodes.add(list.val);
                list = list.next;
            }
        }

        // Step 2: sort
        Collections.sort(nodes);

        // Step 3: convert back to linked list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : nodes) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}