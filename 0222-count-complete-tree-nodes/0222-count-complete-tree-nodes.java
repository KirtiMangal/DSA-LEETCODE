// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */



// class Solution {
//     public int countNodes(TreeNode root) {
//         if (root == null) return 0;
//         return 1 + countNodes(root.left) + countNodes(root.right);
//     }
// }

class Solution {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }

        int leftHeight= getHeightLeft(root);
        int rightHeight= getHeightRight(root);

        if(leftHeight==rightHeight){
            return (1<<leftHeight)-1;
        }

        else{
            return 1+ countNodes(root.left)+ countNodes(root.right);
        }

    }
        public int getHeightLeft(TreeNode root){
            int count=0;
            while(root!=null){
                count++;
                root=root.left;
            }
            return count;
        }

        public int getHeightRight(TreeNode root){
            int count=0;
            while(root!=null){
                count++;
                root=root.right;
            }
            return count; 
    }
}

