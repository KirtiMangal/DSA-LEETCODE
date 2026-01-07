class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // Step 1: compute total sum
        totalSum = treeSum(root);

        // Step 2: compute max product
        subtreeSum(root);

        return (int)(maxProduct % MOD);
    }

    // First DFS: total sum
    private long treeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + treeSum(node.left) + treeSum(node.right);
    }

    // Second DFS: try every split
    private long subtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = subtreeSum(node.left);
        long right = subtreeSum(node.right);

        long currSum = node.val + left + right;

        long product = currSum * (totalSum - currSum);
        maxProduct = Math.max(maxProduct, product);

        return currSum;
    }
}
