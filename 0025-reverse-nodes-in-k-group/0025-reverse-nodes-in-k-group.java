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
    public ListNode reverseKGroup(ListNode head, int k) {
         ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node
            ListNode kth = groupPrev;

            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // Fewer than k nodes remain
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            // Reverse current group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous part to reversed group
            ListNode oldGroupStart = groupPrev.next;
            groupPrev.next = kth;

            // Move to next group
            groupPrev = oldGroupStart;
        }

        return dummy.next;
    }
}