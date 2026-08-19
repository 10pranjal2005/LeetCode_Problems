import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Store only rows that have reserved seats
        Map<Integer, Integer> map = new HashMap<>();

        // Create a bitmask for every reserved seat
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }

        // Every completely empty row can fit 2 groups
        int ans = (n - map.size()) * 2;

        // Seat groups:
        // 2,3,4,5
        int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);

        // 4,5,6,7
        int middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);

        // 6,7,8,9
        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for (int mask : map.values()) {

            boolean canLeft = (mask & left) == 0;
            boolean canMiddle = (mask & middle) == 0;
            boolean canRight = (mask & right) == 0;

            if (canLeft && canRight) {
                // Can place two groups:
                // 2-5 and 6-9
                ans += 2;
            } 
            else if (canLeft || canMiddle || canRight) {
                // Can place at least one group
                ans++;
            }
        }

        return ans;
    }
}