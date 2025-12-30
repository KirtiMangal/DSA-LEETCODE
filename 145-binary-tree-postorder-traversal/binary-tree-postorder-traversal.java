class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
         return result;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            result.add(curr.val);

            if (curr.left != null) 
            st.push(curr.left);
            
            if (curr.right != null) 
            st.push(curr.right);
        }

        Collections.reverse(result);
        return result;
    }
}
