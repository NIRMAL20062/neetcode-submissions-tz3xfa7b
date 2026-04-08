class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }
}
// ```

// **Walkthrough:**
// ```
// l1: 2 -> 4 -> 3   (represents 342)
// l2: 5 -> 6 -> 4   (represents 465)

// Step 1: 2+5=7,  carry=0  → node(7)
// Step 2: 4+6=10, carry=1  → node(0)
// Step 3: 3+4+1=8,carry=0  → node(8)

// Result: 7 -> 0 -> 8  (represents 807) ✓
// ```

// ---

// **Why your string approach has problems:**
// - Numbers can be **astronomically large** — overflow `int`/`long`
// - Extra passes (2 reversals + string conversion) = messy
// - Edge cases with carry at the end are harder to handle

// ---

// **Key Insights:**
// - `sum % 10` → current digit
// - `sum / 10` → carry to next
// - `carry != 0` in while condition handles the **final carry** edge case
// ```
// 999 + 1 = 1000
// 9->9->9  +  1
// Step1: 9+1=10 → node(0), carry=1
// Step2: 9+0+1=10 → node(0), carry=1
// Step3: 9+0+1=10 → node(0), carry=1
// Step4: l1,l2 null but carry=1 → node(1)
// Result: 0->0->0->1  ✓