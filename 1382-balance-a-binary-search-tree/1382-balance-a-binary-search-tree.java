class Solution {
    List<Integer> values = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return buildBalanced(0, values.size() - 1);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        values.add(node.val);
        inorder(node.right);
    }

    private TreeNode buildBalanced(int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(values.get(mid));

        root.left = buildBalanced(left, mid - 1);
        root.right = buildBalanced(mid + 1, right);

        return root;
    }
}
