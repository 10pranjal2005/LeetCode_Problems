class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode p = d;
        while (true) {
            ListNode end = p;
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
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
