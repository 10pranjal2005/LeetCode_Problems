class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Find length and tail
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // Adjust k
        k %= n;
        if (k == 0) return head;

        // Make it circular
        tail.next = head;

        // Move to new tail: (n - k) steps
        int steps = n - k;
        ListNode newTail = head;
        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // New head is next of newTail
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
