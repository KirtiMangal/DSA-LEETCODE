// class Solution {
//     public int maxArea(int[] height) {
//         int n= height.length;
//         int ans=0;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 int len= Math.min(height[i],height[j]);
//                 int width= j-i;
//                 int area= len*width;
//                 ans= Math.max(ans,area);
//             }
//         }

//         return ans;
//     }
// }

class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int left=0;
        int right=n-1;
        int max=0;

        while(left<right){
            int len= Math.min(height[left],height[right]);
            int width= right-left;
            int area= len*width;
            max= Math.max(max,area);

            if(height[left]<height[right]){
                left++;
            }

            else{
                right--;
            }
        }

        return max;
    }}