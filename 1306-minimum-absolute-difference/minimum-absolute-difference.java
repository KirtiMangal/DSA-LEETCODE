class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        int n= arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;

      
        for(int i=1; i<n; i++) {
            min = Math.min(min, arr[i]-arr[i-1]);
        }

        for(int i=1; i<n; i++) {
            int diff = arr[i]-arr[i-1];
            
            if(diff==min) {
                ans.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return ans;
    }
}