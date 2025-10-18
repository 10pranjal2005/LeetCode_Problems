class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        int k = 0;
        int last = nums[0];
        for (int num : nums) {
            if (num != last || k == 0) {
                nums[k++] = num;
                last = num;
            }
        }
        return k;
    }
}
