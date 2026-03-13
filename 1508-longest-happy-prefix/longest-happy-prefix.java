class Solution {
    public String longestPrefix(String s) {
        int n= s.length();
        int[] lps= new int[n];

        int pref=0;
        int suff=1;

        while(suff<n){
            if(s.charAt(pref)==s.charAt(suff)){
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
        return s.substring(0, lps[n-1]);
    }
}