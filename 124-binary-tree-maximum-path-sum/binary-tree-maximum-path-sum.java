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
    int max= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sum(root);
        return max;
    }

    public int sum(TreeNode root){
        if(root==null)
        return 0;

        int lsum= sum(root.left);
        int rsum= sum(root.right);

        int lh= Math.max(0,lsum);
        int rh= Math.max(0,rsum);

        int total= lh+rh+root.val;
        max= Math.max(max,total);

        return root.val+ Math.max(lh,rh);

    }
}