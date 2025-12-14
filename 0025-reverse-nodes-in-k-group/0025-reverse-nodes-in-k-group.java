class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode p = d;

        while (p != null) {
            ListNode e = p;
            for (int i = 0; i < k && e != null; i++) {
                e = e.next;
            }
            if (e == null) break;
            ListNode a = p.next;
            ListNode b = a.next;

            for (int i = 1; i < k; i++) {
                a.next = b.next;
                b.next = p.next;
                p.next = b;
                b = a.next;
            }
            p = a;
        }
        return d.next;
    }
}
