class Solution {
    private int preIndex = 0;
    private int[] preorder;
    private Map<Integer,Integer> inorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        preIndex = 0;
        inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inorderIndex.put(inorder[i], i);
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int idx = inorderIndex.get(rootVal); // position in inorder
        // build left and right using inorder boundaries
        root.left = build(inLeft, idx - 1);
        root.right = build(idx + 1, inRight);

        return root;
    }
}