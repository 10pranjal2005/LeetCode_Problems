class Solution {
    
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }
        
        // Build the binary number
        current = current * 2 + node.val;
        
        // If leaf node, return the number formed
        if (node.left == null && node.right == null) {
            return current;
        }
        
        // Recur left and right
        return dfs(node.left, current) + dfs(node.right, current);
    }
}