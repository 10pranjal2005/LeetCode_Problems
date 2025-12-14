class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode c = head;

        for (int i = 0; i < k; i++) {
            if (c == null) return head;
            c = c.next;
        }

        ListNode prev = null, cur = head;
        for (int i = 0; i < k; i++) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }

        head.next = reverseKGroup(cur, k);
        return prev;
    }
}
