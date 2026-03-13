// class Solution {
//     public boolean repeatedSubstringPattern(String s) {
//         int n= s.length();
//         int pref=0;
//         int suff=1;
        
//         int[] lps= new int[n];
//         while(suff<n){
//             if(s.charAt(suff)==s.charAt(pref)){
//                 pref++;
//                 lps[suff]=pref;
//                 suff++;
//             }

//             else{
//                 if(pref!=0){
//                     pref= lps[pref-1];
//                 }

//                 else{
//                     lps[suff]=0;
//                     suff++;
//                 }
//             }
//         }

//         return s.substring(0,lps[n-1]);
//     }
// }


class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n= s.length();
        int pref=0;
        int suff=1;
        
        int[] lps= new int[n];
        
        while(suff<n){
            if(s.charAt(suff)==s.charAt(pref)){
                pref++;
                lps[suff]=pref;
                suff++;
            }
            else{
                if(pref!=0){
                    pref= lps[pref-1];
                }
                else{
                    lps[suff]=0;
                    suff++;
                }
            }
        }

        int len = lps[n-1];
        return (len > 0 && n % (n - len) == 0);
    }
}