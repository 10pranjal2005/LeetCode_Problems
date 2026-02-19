class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, 1);   // Base case
        
        return dfs(root, 0, targetSum, prefixMap);
    }
    
    private int dfs(TreeNode node, long currSum, int targetSum, 
                    HashMap<Long, Integer> prefixMap) {
        
        if (node == null) return 0;
        
        currSum += node.val;
        
        int count = prefixMap.getOrDefault(currSum - targetSum, 0);
        
        prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);
        
        count += dfs(node.left, currSum, targetSum, prefixMap);
        count += dfs(node.right, currSum, targetSum, prefixMap);
        
        prefixMap.put(currSum, prefixMap.get(currSum) - 1); // Backtrack
        
        return count;
    }
}
