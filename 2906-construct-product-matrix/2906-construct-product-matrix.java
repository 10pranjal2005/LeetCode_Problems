class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;
        
        int size = n * m;
        int[] arr = new int[size];
        
        // Flatten matrix
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[index++] = grid[i][j] % mod;
            }
        }
        
        int[] prefix = new int[size];
        int[] suffix = new int[size];
        
        // Build prefix array
        prefix[0] = 1;
        for(int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % mod;
        }
        
        // Build suffix array
        suffix[size - 1] = 1;
        for(int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i + 1]) % mod;
        }
        
        // Build result matrix
        int[][] result = new int[n][m];
        index = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result[i][j] = (prefix[index] * suffix[index]) % mod;
                index++;
            }
        }
        
        return result;
    }
}