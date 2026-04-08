class Solution {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    TreeNode invert(TreeNode node) {
        if (node == null)
            return null;

        swap(node);

        invert(node.left);
        invert(node.right);

        return node;
    }

    void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left     = node.right;
        node.right    = temp;
    }
}