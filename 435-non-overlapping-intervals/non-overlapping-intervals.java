class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n= intervals.length;
        
        if(n==0)
        return 0;

        Arrays.sort(intervals,Comparator.comparingInt(a->a[1]));
        int previous=0;
        int count=1;

        for(int i=1;i<n;i++){
            if(intervals[i][0]>=intervals[previous][1]){
                previous=i;

            count++;
        }
        }
    
    return n-count;
}
}