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

// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> result= new ArrayList<>();
//         if(root==null){
//             return result;
//         }

//         Stack<TreeNode> st= new Stack<>();
//         st.push(root);

//         while(!st.isEmpty()){
//             TreeNode current= st.pop();
//             result.add(current.val);

//             if(current.left!=null){
//                 st.push(current.left);
//             }

//             if(current.right!=null){
//                 st.push(current.right);
//             }

//         }
//             Collections.reverse(result);
//             return result;
//         }
//     }

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        if(root==null){
            return result;
        }

        Stack<TreeNode> s1= new Stack<>();
        Stack<TreeNode> s2= new Stack<>();
        s1.push(root);

        while(!s1.isEmpty()){
            TreeNode current= s1.pop();
            s2.push(current);

            if(current.left!=null){
                s1.push(current.left);
            }

            if(current.right!=null){
                s1.push(current.right);
            }
        }
        
        while(!s2.isEmpty()){
            result.add(s2.pop().val);
        }

        return result;
    }}