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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n= postorder.length;
        idx= n-1;

        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(inorder, postorder ,0,inorder.length-1,map);
    }

        public TreeNode build(int in[], int post[], int inst, int inend, Map<Integer,Integer> map){
            if(inst> inend){
                return null;
            }

            TreeNode root= new TreeNode(post[idx--]);
            int index= map.get(root.val);
            root.right= build(in,post,index+1, inend,map);
            root.left= build(in,post,inst,index-1,map);

            return root;
        }
    }
