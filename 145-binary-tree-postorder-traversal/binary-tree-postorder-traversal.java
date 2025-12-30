// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> result= new ArrayList<>();
//         postorder(root,result);
//         return result;
//     }

//     public void postorder(TreeNode node, List<Integer> result){
//         if(node==null){
//             return;
//         }

//         postorder(node.left,result);
//         postorder(node.right,result);
//         result.add(node.val);
//     }
// }


// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         LinkedList<Integer> result= new LinkedList<>();

//         if(root==null){
//             return result;
//         }

//         Stack<TreeNode> st= new Stack<>();
//         st.push(root);

//         while(!st.isEmpty()){
//         TreeNode current= st.pop();
//         result.addFirst(current.val);

//         if(current.left!=null){
//             st.push(current.left);
//         }

//         if(current.right!=null){
//             st.push(current.right);
//         }
//     }
    
//     return result;
// }}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        if(root==null){
            return result;
        }

        Stack<TreeNode> st= new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode current= st.pop();
            result.add(current.val);

            if(current.left!=null){
                st.push(current.left);
            }

            if(current.right!=null){
                st.push(current.right);
            }

        }
            Collections.reverse(result);
            return result;
        }
    }