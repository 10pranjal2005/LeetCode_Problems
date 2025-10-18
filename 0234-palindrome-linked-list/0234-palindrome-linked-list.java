class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1️⃣ Find the middle using slow/fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2️⃣ Reverse the second half
        ListNode secondHalf = reverse(slow);

        // 3️⃣ Compare the two halves
        ListNode p1 = head, p2 = secondHalf;
        boolean isPalin = true;
        while (p2 != null) {  // only need to check second half
            if (p1.val != p2.val) {
                isPalin = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4️⃣ Optional: restore list
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
