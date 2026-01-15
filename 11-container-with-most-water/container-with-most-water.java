// class Solution {
//     public int maxArea(int[] height) {

//         int n= height.length;
//         int low=0;
//         int high=n-1;
//         int max=0;

//         while(low<=high){
//             int length= Math.min(height[low], height[high]);
//             int width= high-low;
//             int area= length*width;

//             max= Math.max(max,area);

//             if(height[low]<height[high]){
//                 low++;
//             }

//             else{
//                 high--;
//             }
//         }

//         return max;
//     }
// }


class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int left=0;
        int right= n-1;

        int max=0;

        while(left<=right){
            int length= Math.min(height[left], height[right]);
            int width= right-left;
            int area= length*width;

            max= Math.max(max,area);

            if(height[left]<height[right]){
                left++;
            }

            else{
                right--;
            }
        }

        return max;
    }
}