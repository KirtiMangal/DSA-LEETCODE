// class Solution {
//     public int maxProfit(int[] prices) {

//         return solve(0,1,prices,2);
//     }

//         public int solve(int i,int buy, int[] prices, int limit){
//             int n= prices.length;
//             int max=0;
            
//             if(i==n){
//                 return 0;
//             }

//             if(limit==0){
//                 return 0;
//             }

//             if(buy==1){
//                 int take= -prices[i]+ solve(i+1,0,prices,limit);
//                 int skip= solve(i+1,1,prices,limit);

//                 return Math.max(take,skip);

//             }

//             else{
//                 int take= prices[i]+ solve(i+1,1,prices,limit-1);
//                 int skip= solve(i+1,0,prices,limit);

//                 return Math.max(take,skip);
//             }
//         }
//     }

class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;

        int buy1= Integer.MIN_VALUE;
        int sell1= 0;

        int buy2= Integer.MIN_VALUE;
        int sell2=0;

        for(int price:prices){
            buy1= Math.max(buy1, -price);
            sell1= Math.max(sell1, buy1+price);

            buy2= Math.max(buy2, sell1-price);
            sell2= Math.max(sell2, buy2+price);
        }

        return sell2;
    }}