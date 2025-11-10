class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // If tree is empty, create a new node
        if (root == null) {
            return new TreeNode(val);
        }

        // Traverse the tree based on BST property
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root; // Return the unchanged root pointer
    }
}