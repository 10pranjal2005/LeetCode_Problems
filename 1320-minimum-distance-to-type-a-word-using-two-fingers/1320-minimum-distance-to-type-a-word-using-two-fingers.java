class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[n][27][27];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 27; j++) {
                for (int k = 0; k < 27; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE / 2;
                }
            }
        }

        int first = word.charAt(0) - 'A';
        dp[0][first][26] = 0;
        dp[0][26][first] = 0;

        for (int i = 1; i < n; i++) {
            int curr = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';

            for (int f1 = 0; f1 < 27; f1++) {
                for (int f2 = 0; f2 < 27; f2++) {
                    if (dp[i - 1][f1][f2] == Integer.MAX_VALUE / 2) continue;

                    if (f1 == prev) {
                        dp[i][curr][f2] = Math.min(
                            dp[i][curr][f2],
                            dp[i - 1][f1][f2] + dist(prev, curr)
                        );
                    }

                    if (f2 == prev) {
                        dp[i][f1][curr] = Math.min(
                            dp[i][f1][curr],
                            dp[i - 1][f1][f2] + dist(prev, curr)
                        );
                    }

                    dp[i][curr][f2] = Math.min(
                        dp[i][curr][f2],
                        dp[i - 1][f1][f2] + dist(f1, curr)
                    );

                    dp[i][f1][curr] = Math.min(
                        dp[i][f1][curr],
                        dp[i - 1][f1][f2] + dist(f2, curr)
                    );
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                res = Math.min(res, dp[n - 1][i][j]);
            }
        }

        return res;
    }

    private int dist(int a, int b) {
        if (a == 26 || b == 26) return 0;
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}