import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            values.add(currentNode.val);
            currentNode = currentNode.next;
        }
        
        int left = 0;
        int right = values.size() - 1;
        while (left < right) {
            if (!values.get(left).equals(values.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}