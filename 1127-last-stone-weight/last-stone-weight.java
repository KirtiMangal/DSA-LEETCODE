class Solution {
    public int lastStoneWeight(int[] stones) {
        int n= stones.length;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            pq.add(stones[i]);
        }

            while(pq.size()>1){
                int weight= pq.poll();

                weight-= pq.poll();

                if(weight>0){
                    pq.add(weight);
                }

            }

        return pq.isEmpty()?0 : pq.peek();
    }
}