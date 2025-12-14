class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode p = d;

        while (p.next != null && p.next.next != null) {
            ListNode a = p.next;
            ListNode b = a.next;

            a.next = b.next;
            b.next = a;
            p.next = b;

            p = a; // move to next pair
        }

        return d.next;
    }
}
