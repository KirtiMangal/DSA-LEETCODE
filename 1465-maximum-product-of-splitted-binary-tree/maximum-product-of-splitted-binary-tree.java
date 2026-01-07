class Solution {
    long sum = 0;
    long max = 0;
    int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        sum = treeSum(root);

        // Step 2: compute max product
        subtreeSum(root);

        return (int)(max % MOD);
    }

    // First DFS: total sum
    private long treeSum(TreeNode node) {
        if (node == null) 
        return 0;
        
        return node.val + treeSum(node.left) + treeSum(node.right);
    }

    // Second DFS: try every split
    private long subtreeSum(TreeNode node) {
        if (node == null) 
        return 0;

        long left = subtreeSum(node.left);
        long right = subtreeSum(node.right);

        long currSum = node.val + left + right;

        long product = currSum * (sum - currSum);
        max = Math.max(max, product);

        return currSum;
    }
}
