class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (areEqual(mat, target)) {
                return true;
            }
            mat = rotate90(mat);
        }
        return false;
    }

    private boolean areEqual(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] rotate90(int[][] mat) {
        int n = mat.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = mat[i][j];
            }
        }

        return rotated;
    }
}