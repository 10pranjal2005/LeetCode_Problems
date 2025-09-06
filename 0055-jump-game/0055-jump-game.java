class Solution {
    public boolean canJump(int[] nums) {
        int jump = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > jump) {
                return false;
            }
            jump = Math.max(jump, i + nums[i]);
            if (jump >= n - 1) {
                return true;
            }
        }
        return true;
    }
}