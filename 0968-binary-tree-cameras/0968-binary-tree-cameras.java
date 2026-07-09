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
    int sum=0;
    public int minCameraCover(TreeNode root) {
        if(dfs(root)==0)
        {
            sum++;
        }
            return sum;
    }
        
        
        private int dfs(TreeNode node){

            if(node==null){
                return 1;
            }

            int left= dfs(node.left);
            int right= dfs(node.right);

            if(left==0 || right==0){
                sum++;
                return 2;
            }

            else if(left==2 || right==2){
                return 1;
            }

            else{
                return 0;
            }
        }
}