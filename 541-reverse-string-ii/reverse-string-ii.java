// class Solution {
//     public String reverseStr(String s, int k) {

//     char[] arr = s.toCharArray();
//     int n = arr.length;
//     int i = 0;
//     while(i<n){
//         int rem= n-i;

//         if(rem>=k){
//             int left=i;
//             int right= i+k-1;

//             while(left<right){
//             char temp=arr[left];
//             arr[left]= arr[right];
//             arr[right]= temp;

//             left++;
//             right--;
//         }

//         if(rem>=2*k){
//             i+=2*k;
//         }

//         else{
//             break;
//         }

//         }

//         else{
//             int left=i;
//             int right= n-1;

//             while(left<right){
//                 char temp= arr[left];
//                 arr[left]= arr[right];
//                 arr[right]= temp;

//                 left++;
//                 right--;
//             }

//             break;
//         }
//     }
//     return new String(arr);
//     }
// }

class Solution {
    public String reverseStr(String s, int k) {
        char[] arr= s.toCharArray();
        int n= s.length();

        for(int i=0;i<n;i+=2*k){
            int left=i;
            int right= Math.min(i+k-1, n-1);

            while(left<right){
                char temp= arr[left];
                arr[left]= arr[right];
                arr[right]= temp;

                left++;
                right--;
            }
        }

        return new String(arr);
    }}