// class Solution {
//     public String largestOddNumber(String num) {
//         int n= num.length();
//         for(int i=n-1;i>=0;i--){
//             int digit= num.charAt(i)-'0';

//             if(digit%2==1){
//                 return num.substring(0,i+1);
//             }
//         }

//         return "";
//     }
// }

class Solution {
    public String largestOddNumber(String num) {
        int n= num.length()-1;

        while(n>=0){
            int digit= num.charAt(n)-'0';

            if(digit%2!=0){
                return num.substring(0,n+1);
            }
                n--;
         
            
        }
           
    
    return "";
        }    }