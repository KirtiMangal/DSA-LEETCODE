class Solution {
    public int hIndex(int[] citations) {
        int n= citations.length;
        int hidx=0;
        Arrays.sort(citations);

        for(int i=n-1;i>=0;i--){
            if(citations[i]>=n-i){
                hidx++;
            }
        }
        return hidx;
    }
}