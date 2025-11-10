class Solution {
    public int maxDepth(TreeNode root) {
        // Base case: if the node is null, depth is 0
        if (root == null) {
            return 0;
        }
        // Recursively find depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // The depth of the tree is the greater of the two, plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}