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
if (lists == null || lists.length == 0) {
            return null;
        }

        int interval = 1;

        while (interval < lists.length) {

            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }

            interval *= 2;
        }

        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (a != null && b != null) {

            if (a.val <= b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }

            current = current.next;
        }

        current.next = (a != null) ? a : b;

        return dummy.next;

    }
}