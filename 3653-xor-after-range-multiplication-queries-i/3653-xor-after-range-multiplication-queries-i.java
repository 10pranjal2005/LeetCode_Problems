class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1000000007L;

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];

            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (int)((nums[idx] * 1L * v) % MOD);
            }
        }

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}