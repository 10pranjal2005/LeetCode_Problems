/*class Solution {
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
}*/
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}