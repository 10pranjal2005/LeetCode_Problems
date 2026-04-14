import java.util.*;

class Solution {
    long[][] dp;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();
        int m = factory.length;

        dp = new long[n][m];
        for (long[] row : dp) Arrays.fill(row, -1);

        return solve(robot, factory, 0, 0);
    }

    private long solve(List<Integer> robot, int[][] factory, int i, int j) {
        if (i == robot.size()) return 0;
        if (j == factory.length) return Long.MAX_VALUE / 2;

        if (dp[i][j] != -1) return dp[i][j];

        long res = solve(robot, factory, i, j + 1);

        long dist = 0;
        for (int k = 0; k < factory[j][1] && i + k < robot.size(); k++) {
            dist += Math.abs(robot.get(i + k) - factory[j][0]);
            long next = solve(robot, factory, i + k + 1, j + 1);
            if (next != Long.MAX_VALUE / 2) {
                res = Math.min(res, dist + next);
            }
        }

        return dp[i][j] = res;
    }
}