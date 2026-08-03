class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] dp = new Integer[n];
        int score = solve(stoneValue, 0, dp);
        if (score > 0) return "Alice";
        else if (score < 0) return "Bob";
        else
            return "Tie";
    }
    private int solve(int[] stones, int index, Integer[] dp) {
        if (index == stones.length) return 0;
        if (dp[index] != null) return dp[index];
        int best = Integer.MIN_VALUE;
        int sum = 0;
        for (int take = 0; take < 3 && index + take < stones.length; take++) {
            sum += stones[index + take];
            best = Math.max(
                best,
                sum - solve(stones, index + take + 1, dp)
            );
        }
        return dp[index] = best;
    }
}