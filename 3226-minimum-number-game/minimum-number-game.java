class Solution {
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            pq.add(nums[i]);
        }

        int idx = 0;

        while(pq.size() >= 2){
            int first = pq.poll();   
            int second = pq.poll();  

            arr1[idx++] = second;
            arr1[idx++] = first;
        }

        return arr1;
    }
}