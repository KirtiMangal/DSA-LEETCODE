class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //List<Integer> result = new ArrayList<>();

        LinkedList<Integer> result= new LinkedList<>();
        if(root==null){
            return result;
        }

        Stack<TreeNode> st= new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode current= st.pop();
            result.addFirst(current.val);

            if(current.left!=null){
                st.push(current.left);
            }

            if(current.right!=null){
                st.push(current.right);
            }
        }

        return result;
    }
}