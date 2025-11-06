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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
        return false;
        

Queue<TreeNode> q= new LinkedList<>();
q.add(root);
boolean isfound= false;

while(!q.isEmpty() && !isfound){
    int levelsize= q.size();
    boolean xFound= false;
    boolean yFound= false;

    for(int i=0;i<levelsize;i++){
        TreeNode curr= q.poll();

        if(curr.left!=null && curr.right!=null){
          if((curr.left.val==x && curr.right.val==y)||
            (curr.left.val==y && curr.right.val==x)){
                return false;
            }
        }
            
       
            if(curr.left!=null){
            q.add(curr.left);

            if(curr.left.val==x)
            xFound=true;

            if(curr.left.val==y)
            yFound=true;
    }

    if(curr.right!=null){
    q.add(curr.right);

    if(curr.right.val==x)
    xFound=true;

    if(curr.right.val==y)
    yFound=true;
}}

if(xFound && yFound)
return true;

if(xFound || yFound)
return false;
}

return false;
}}