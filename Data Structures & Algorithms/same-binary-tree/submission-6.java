/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isEqual(p ,q);
    }

    public boolean isEqual(TreeNode p, TreeNode q){
        if(q==null && p ==null){
            return true;
        }
        if(q==null || p==null){
            return false;
        }

        return (q.val == p.val) && isEqual(p.left , q.left) && isEqual(p.right , q.right);
    }
}
