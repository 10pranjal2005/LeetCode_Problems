class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = new ListNode(0, head);
        ListNode n1 = head;
        ListNode n2 = prev;
        for (int i = 0; i < n; i++) {
            n1 = n1.next;
        }
        while (n1 != null) {
            n2 = n2.next;
            n1 = n1.next;
        }
        n2.next = n2.next.next;
        
        return prev.next;
    }
}