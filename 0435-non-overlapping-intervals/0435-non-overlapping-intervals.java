class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // List<int[]> result= new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int n= intervals.length;
        int previous=0;
        int count=1;
        
        for(int i=1;i<n;i++){
            if(intervals[i][0] >= intervals[previous][1]){
                previous=i;

                count++;
            }
        }
        return n- count;
    }
}