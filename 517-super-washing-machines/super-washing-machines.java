class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;

        int total = 0;
        for (int x : machines)
            total += x;

        if (total % n != 0)
            return -1;

        int target = total / n;

        int prefix = 0;
        int ans = 0;

        for (int x : machines) {
            int diff = x - target;
            prefix += diff;

            ans = Math.max(ans, Math.abs(prefix));
            ans = Math.max(ans, diff);
        }

        return ans;
    }
}
