class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        long total = 0;
        long current = 0;

        for (int i = 0; i < n; i++) {
            total += nums[i];
            current += (long) i * nums[i];
        }

        long answer = current;

        for (int i = n - 1; i >= 1; i--) {
            current = current + total - (long) n * nums[i];
            answer = Math.max(answer, current);
        }

        return (int) answer;
    }
}