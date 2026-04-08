class Solution {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    TreeNode invert(TreeNode node) {
        if (node == null)
            return null;

        // swap
        TreeNode temp = node.left;
        node.left     = node.right;
        node.right    = temp;

        invert(node.left);
        invert(node.right);

        return node;
    }
}