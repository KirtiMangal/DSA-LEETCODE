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
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex= postorder.length-1;

        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(inorder,postorder,0,inorder.length-1,map);
    }

    public TreeNode helper(int[] inorder,int[] postorder, int inStart, int inEnd, Map<Integer,Integer> map){
        
        if(inStart>inEnd){
            return null;
        }

        int rootVal= postorder[postIndex--];
        TreeNode root= new TreeNode(rootVal);
        int inIndex= map.get(rootVal);

        root.right= helper(inorder,postorder,inIndex+1,inEnd,map);
        root.left= helper(inorder,postorder, inStart, inIndex-1,map);

        return root;
            }
}