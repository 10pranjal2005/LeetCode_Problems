class Solution {
    private ListNode front;

    public boolean isPalindrome(ListNode head) {
        front = head;
        return check(head);
    }

    private boolean check(ListNode node) {
        if (node == null) return true;
        if (!check(node.next)) return false;
        if (front.val != node.val) return false;
        front = front.next;
        return true;
    }
}
