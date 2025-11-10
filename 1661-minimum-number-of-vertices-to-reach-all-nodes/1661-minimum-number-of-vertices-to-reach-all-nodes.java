class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] hasIncoming = new boolean[n];

        // Mark all nodes that have an incoming edge
        for (List<Integer> edge : edges) {
            hasIncoming[edge.get(1)] = true;
        }

        // Collect all nodes that have no incoming edges
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!hasIncoming[i]) {
                result.add(i);
            }
        }

        return result;
    }
}