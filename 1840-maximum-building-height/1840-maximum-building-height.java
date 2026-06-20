import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        if (restrictions.length == 0) {
            return n - 1;
        }

        int m = restrictions.length;

        int[][] arr = new int[m + 1][2];

        for (int i = 0; i < m; i++) {
            arr[i][0] = restrictions[i][0];
            arr[i][1] = restrictions[i][1];
        }

        arr[m][0] = 1;
        arr[m][1] = 0;

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int len = arr.length;

        // Left to Right
        for (int i = 1; i < len; i++) {
            arr[i][1] = Math.min(
                arr[i][1],
                arr[i - 1][1] + (arr[i][0] - arr[i - 1][0])
            );
        }

        // Right to Left
        for (int i = len - 2; i >= 0; i--) {
            arr[i][1] = Math.min(
                arr[i][1],
                arr[i + 1][1] + (arr[i + 1][0] - arr[i][0])
            );
        }

        long ans = 0;

        for (int i = 1; i < len; i++) {
            int x1 = arr[i - 1][0];
            int h1 = arr[i - 1][1];

            int x2 = arr[i][0];
            int h2 = arr[i][1];

            long peak = ((long) h1 + h2 + (x2 - x1)) / 2;

            ans = Math.max(ans, peak);
        }

        int lastPos = arr[len - 1][0];
        int lastHeight = arr[len - 1][1];

        ans = Math.max(ans, (long) lastHeight + (n - lastPos));

        return (int) ans;
    }
}