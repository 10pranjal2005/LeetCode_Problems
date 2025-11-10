class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        
        // If the starting pixel already has the target color, no need to change
        if (originalColor == color) {
            return image;
        }

        // Start recursive flood fill
        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Base conditions: Out of bounds or color mismatch
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != originalColor) {
            return;
        }

        // Change color
        image[r][c] = newColor;

        // Move in 4 directions (up, down, left, right)
        dfs(image, r - 1, c, originalColor, newColor);
        dfs(image, r + 1, c, originalColor, newColor);
        dfs(image, r, c - 1, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor);
    }
}
