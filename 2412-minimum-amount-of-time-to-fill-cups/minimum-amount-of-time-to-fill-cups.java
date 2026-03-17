class Solution {
    public int fillCups(int[] amount) {
        int n= amount.length;
        int ans=0;

        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        pq.add(amount[0]);
        pq.add(amount[1]);
        pq.add(amount[2]);

        while(!pq.isEmpty() && pq.peek()>0){
            int p= pq.poll();
            int q= 0;

            if(!pq.isEmpty()){
            q= pq.poll();
            }

            p--;

            if(q>0)
            q--;

            if(p>0)
            pq.add(p);

            if(q>0)
            pq.add(q);

            ans++;
        }

        return ans;    
    }
}