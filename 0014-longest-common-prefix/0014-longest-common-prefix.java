// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         String first= strs[0];
//         int n= first.length();
//         int m= strs.length;

//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(i==strs[j].length() || (strs[j].charAt(i)!=first.charAt(i))){
//                     return first.substring(0,i);
//                 }
//             }
//         }

//         return first;
//     }
// }

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n= strs.length;
        Arrays.sort(strs);

        String first= strs[0];
        String last= strs[n-1];

        int i=0;
        while(i<first.length() && i<last.length() && first.charAt(i)==last.charAt(i)){
            i++;
        }
    

    return first.substring(0,i);
    
    }
}