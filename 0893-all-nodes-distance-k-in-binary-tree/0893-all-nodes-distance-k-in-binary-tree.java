/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMap= new HashMap<>();
        markParents(root,parentMap);

        Queue<TreeNode> queue= new LinkedList<>();
        Set<TreeNode> visited= new HashSet<>();

        queue.add(target);
        visited.add(target);
        int current=0;

        while(!queue.isEmpty()){
            int size= queue.size();
            if(current==k)
            break;

            current++;

            for(int i=0;i<size;i++){
                TreeNode curr= queue.poll();

                if(curr.left!=null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    queue.add(curr.left);
                }

                if(curr.right!=null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    queue.add(curr.right);
                }

                TreeNode parent= parentMap.get(curr);
                if(parent!=null && !visited.contains(parent)){
                    visited.add(parent);
                    queue.add(parent);
                }
            }
        }

        List<Integer> result= new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }
        return result;
    }
    

       private void markParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.add(curr.left);
            }

            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.add(curr.right);
            }
        }
    }
}