import java.util.*;

class Solution {

    int[][] mx;
    int[][] mn;
    int[] lg;
    int[] nums;

    private long value(int l, int r) {
        int len = r - l + 1;
        int k = lg[len];

        int maxVal = Math.max(mx[k][l], mx[k][r - (1 << k) + 1]);
        int minVal = Math.min(mn[k][l], mn[k][r - (1 << k) + 1]);

        return (long) maxVal - minVal;
    }

    public long maxTotalValue(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;

        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }

        int m = lg[n] + 1;

        mx = new int[m][n];
        mn = new int[m][n];

        for (int i = 0; i < n; i++) {
            mx[0][i] = nums[i];
            mn[0][i] = nums[i];
        }

        for (int p = 1; p < m; p++) {
            int len = 1 << p;

            for (int i = 0; i + len <= n; i++) {
                mx[p][i] = Math.max(
                        mx[p - 1][i],
                        mx[p - 1][i + (len >> 1)]
                );

                mn[p][i] = Math.min(
                        mn[p - 1][i],
                        mn[p - 1][i + (len >> 1)]
                );
            }
        }

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            pq.offer(new Node(l, n - 1, value(l, n - 1)));
        }

        long ans = 0;

        while (k-- > 0 && !pq.isEmpty()) {
            Node cur = pq.poll();

            ans += cur.val;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                pq.offer(new Node(
                        cur.l,
                        nr,
                        value(cur.l, nr)
                ));
            }
        }

        return ans;
    }

    static class Node {
        int l;
        int r;
        long val;

        Node(int l, int r, long val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }
}