class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = 0;

        for (int n : nums) {
            int take = prev2 + n;
            int skip = prev1;
            int c = Math.max(take, skip);
            prev2 = prev1;
            prev1 = c;
        }
        return prev1;
    }
}
