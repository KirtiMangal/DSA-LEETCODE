// class Solution {
//     public long maxSubarraySum(int[] nums, int k) {
//         int n= nums.length;
//         long sum;
//         long max= Long.MIN_VALUE;

//         for(int i=0;i<n;i++){
//             sum=0;
//             for(int j=i;j<n;j++){
//                 sum+=nums[j];

//                 long length= j-i+1;

//                 if(length%k==0){
//                     max= Math.max(max,sum);
//                 }

//             }

//         }

//         return max;
//     }
// }


class Solution {
    public long maxSubarraySum(int[] nums, int k){
        long[] minPrefix= new long[k];
        int n= nums.length;
        
        for(int i=0;i<k;i++){
            minPrefix[i]= Long.MAX_VALUE;
        }

        long prefix=0;
        long ans= Long.MIN_VALUE;

        minPrefix[0]=0;

        for(int i=0;i<n;i++){
            prefix+= nums[i];
            int rem= (i+1)%k;

            if(minPrefix[rem]!= Long.MAX_VALUE){
                long valid= prefix- minPrefix[rem];
                ans= Math.max(ans,valid);
            }

            minPrefix[rem]= Math.min(minPrefix[rem], prefix);
        }

        return ans;
    }
}