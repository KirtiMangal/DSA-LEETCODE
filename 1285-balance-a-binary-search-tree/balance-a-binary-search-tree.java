class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        
        // Step 1: Get sorted values
        inorder(root, inorderList);
        
        // Step 2: Build balanced BST
        return buildBalanced(inorderList, 0, inorderList.size() - 1);
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    private TreeNode buildBalanced(List<Integer> list, int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        
        TreeNode root = new TreeNode(list.get(mid));
        
        root.left = buildBalanced(list, start, mid - 1);
        root.right = buildBalanced(list, mid + 1, end);
        
        return root;
    }
}
