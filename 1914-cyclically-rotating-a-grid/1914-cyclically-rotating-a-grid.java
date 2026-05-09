class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top < bottom && left < right) {
            List<Integer> vals = new ArrayList<>();
            List<int[]> pos = new ArrayList<>();

            for (int c = left; c <= right; c++) {
                vals.add(grid[top][c]);
                pos.add(new int[]{top, c});
            }

            for (int r = top + 1; r <= bottom; r++) {
                vals.add(grid[r][right]);
                pos.add(new int[]{r, right});
            }

            for (int c = right - 1; c >= left; c--) {
                vals.add(grid[bottom][c]);
                pos.add(new int[]{bottom, c});
            }

            for (int r = bottom - 1; r > top; r--) {
                vals.add(grid[r][left]);
                pos.add(new int[]{r, left});
            }

            int len = vals.size();
            int shift = k % len;

            for (int i = 0; i < len; i++) {
                int[] p = pos.get(i);
                grid[p[0]][p[1]] = vals.get((i + shift) % len);
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return grid;
    }
}