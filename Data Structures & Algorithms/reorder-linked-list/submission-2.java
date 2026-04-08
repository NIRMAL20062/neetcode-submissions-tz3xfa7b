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
    public void reorderList(ListNode head) {
        
        // 1. Store nodes in the array

        List<ListNode> nodes =new ArrayList<>();

        ListNode curr =head;
        while(curr!=null){
            nodes.add(curr);
            curr=curr.next;
        }
        // 2. Reorder Using the two pointers
        int left = 0;
        int right= nodes.size()-1;

        while(left<right){
            nodes.get(left).next = nodes.get(right);
            left++;
            if(right==left) break;
            nodes.get(right).next = nodes.get(left);
            right--;
        }
        nodes.get(left).next=null;
    }
}
