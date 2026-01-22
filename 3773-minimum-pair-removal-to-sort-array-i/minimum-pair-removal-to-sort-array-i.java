class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>();

        for (int x : nums) 
        arr.add(x);

        int operations = 0;

        while (!isSorted(arr)) {
            int minIndex = 0;

            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) + arr.get(i + 1) <
                    arr.get(minIndex) + arr.get(minIndex + 1)) {
                    minIndex = i;
                }
            }

            arr.set(minIndex, arr.get(minIndex) + arr.get(minIndex + 1));
            arr.remove(minIndex + 1);

            operations++;
        }

        return operations;
    }

    private boolean isSorted(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1)) 
            return false;
        }
        return true;
    }
}
