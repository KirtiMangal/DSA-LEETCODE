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
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx=0;

        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(preorder,inorder,0,inorder.length-1,map);
    }


        public TreeNode build(int pre[],int in[], int inst,int inend,Map<Integer,Integer> map){
            if(inst>inend)
                return null;
            

            TreeNode root= new TreeNode(pre[idx++]);
            int index= map.get(root.val);
            root.left= build(pre,in,inst,index-1,map);
            root.right= build(pre,in,index+1, inend,map);

        

        return root;
        
    }
}