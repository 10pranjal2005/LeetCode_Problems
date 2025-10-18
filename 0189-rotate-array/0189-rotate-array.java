class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k % n == 0) {
            return;
        }
        
        k = k % n;
        int count = 0; // Number of elements placed in their correct positions

        for (int start = 0; count < n; start++) {
            int currentIdx = start;
            int prevValue = nums[start];

            do {
                int nextIdx = (currentIdx + k) % n;
                int temp = nums[nextIdx];
                nums[nextIdx] = prevValue;
                prevValue = temp;
                currentIdx = nextIdx;
                count++;
            } while (start != currentIdx);
        }
    }
}