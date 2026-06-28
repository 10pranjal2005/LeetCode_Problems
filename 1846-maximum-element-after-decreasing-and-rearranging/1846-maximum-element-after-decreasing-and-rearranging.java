import java.util.*;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int cur = 1;

        for (int i = 1; i < arr.length; i++) {
            cur = Math.min(arr[i], cur + 1);
        }

        return cur;
    }
}