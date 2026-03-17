// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         int n= stones.length;
//         PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

//         for(int i=0;i<n;i++){
//             pq.add(stones[i]);
//         }

//             while(pq.size()>1){
//                 int weight= pq.poll();

//                 weight-= pq.poll();

//                 if(weight>0){
//                     pq.add(weight);
//                 }
//             }

//         return pq.isEmpty()?0 : pq.peek();
//     }
// }

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }

        while(pq.size()>1){
            int y= pq.poll();
            int x= pq.poll();

            if(y!=x){
                pq.add(y-x);
            }
        }

        return pq.isEmpty()?0 : pq.peek();

    }}