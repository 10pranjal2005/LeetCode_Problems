class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;  // Save start of even list
        
        while (even != null && even.next != null) {
            
            odd.next = even.next;   // Link next odd
            odd = odd.next;
            
            even.next = odd.next;   // Link next even
            even = even.next;
        }
        
        // Attach even list after odd list
        odd.next = evenHead;
        
        return head;
    }
}
