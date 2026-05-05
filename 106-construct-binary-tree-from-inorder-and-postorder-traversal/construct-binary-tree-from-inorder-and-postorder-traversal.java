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
        int n= inorder.length;

        Map<Integer,Integer> map= new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }

        return helper(postorder,0,inorder.length-1,map);
    }

    public TreeNode helper(int[] postorder, int inStart, int inEnd, Map<Integer,Integer> map){
        if(inStart>inEnd){
            return null;
        }

        int rootVal= postorder[postIndex--];
        TreeNode root= new TreeNode(rootVal);

        int index= map.get(rootVal);

        root.right= helper(postorder,index+1,inEnd,map);
        root.left= helper(postorder,inStart,index-1,map);

        return root;


    }
}