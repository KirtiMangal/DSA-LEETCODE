// class Solution {
//     public int maxProfit(int[] prices) {
        
//         return solve(0,1,prices);
//     }

//         public int solve(int i, int buy, int[] prices){
//             int n= prices.length;

//             if(i==n){
//                 return 0;
//             }

//             if(buy==1){
//                 int take= -prices[i]+ solve(i+1,0,prices);
//                 int skip= solve(i+1,1,prices);

//                 return Math.max(take,skip);
//             }

//             else{
//                 int take= prices[i]+ solve(i+1,1,prices);
//                 int skip= solve(i+1,0,prices);

//                 return Math.max(take,skip);
//             }
//         } }

class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int profit=0;

        for(int i=1;i<n;i++){

            if(prices[i]>prices[i-1]){
                profit+= prices[i]- prices[i-1];
            }
        }

        return profit;
    }}