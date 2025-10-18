class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow);
        ListNode p1 = head, p2 = secondHalf;
        boolean isPalin = true;
        while (p2 != null) { 
            if (p1.val != p2.val) {
                isPalin = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        reverse(secondHalf);
        return isPalin;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
