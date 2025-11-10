class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both are null, they are same
        if (p == null && q == null) return true;
        
        // If one is null and the other is not, they are different
        if (p == null || q == null) return false;
        
        // If values are different, not the same tree
        if (p.val != q.val) return false;
        
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}