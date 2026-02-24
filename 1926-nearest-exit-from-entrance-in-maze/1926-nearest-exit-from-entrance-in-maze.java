import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        
        // Mark entrance as visited
        maze[entrance[0]][entrance[1]] = '+';
        
        int steps = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] dir : directions) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];
                    
                    // Check bounds
                    if (newRow >= 0 && newRow < m &&
                        newCol >= 0 && newCol < n &&
                        maze[newRow][newCol] == '.') {
                        
                        // If border → exit found
                        if (newRow == 0 || newRow == m - 1 ||
                            newCol == 0 || newCol == n - 1) {
                            return steps;
                        }
                        
                        // Mark visited
                        maze[newRow][newCol] = '+';
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        
        return -1;
    }
}