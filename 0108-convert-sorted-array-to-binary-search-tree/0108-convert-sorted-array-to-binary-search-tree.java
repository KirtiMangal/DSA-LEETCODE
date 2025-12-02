class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n= nums.length;
        return build(nums, 0, n- 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) 
        return null;

        int mid = (left + right) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);

        return node;
    }
}
