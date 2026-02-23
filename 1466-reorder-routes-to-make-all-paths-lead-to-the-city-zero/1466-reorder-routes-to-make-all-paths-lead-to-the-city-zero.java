import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build graph
        for (int[] conn : connections) {
            int a = conn[0];
            int b = conn[1];
            
            graph.get(a).add(new int[]{b, 1}); // needs reversal
            graph.get(b).add(new int[]{a, 0}); // correct direction
        }
        
        return dfs(graph, 0, new boolean[n]);
    }
    
    private int dfs(List<List<int[]>> graph, int node, boolean[] visited) {
        visited[node] = true;
        int changes = 0;
        
        for (int[] neighbor : graph.get(node)) {
            int next = neighbor[0];
            int cost = neighbor[1];
            
            if (!visited[next]) {
                changes += cost + dfs(graph, next, visited);
            }
        }
        
        return changes;
    }
}