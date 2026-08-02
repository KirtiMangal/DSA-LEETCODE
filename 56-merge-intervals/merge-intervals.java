class Solution {
    public int[][] merge(int[][] intervals) {
        int n= intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<int[]> list= new ArrayList<>();
        int curr[]= intervals[0];

        for(int i=0;i<n;i++){
            int next[]= intervals[i];

            if(next[0]<=curr[1]){
                curr[1]= Math.max(next[1],curr[1]);
            }

            else{
                list.add(curr);
                curr= next;
            }
        }

        list.add(curr);
        return list.toArray(new int[list.size()][]);
    }
}