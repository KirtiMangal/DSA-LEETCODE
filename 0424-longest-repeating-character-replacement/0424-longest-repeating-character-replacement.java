// class Solution {
//     public int characterReplacement(String s, int k) {
//         int maxlen=0;
//         int maxfreq=0;

//         int n= s.length();
//         for(int i=0;i<n;i++){
//             int[] hash= new int[256];

//             for(int j=i; j<n;j++){
//                 hash[s.charAt(j)]++;

//                 maxfreq= Math.max(maxfreq, hash[s.charAt(j)]);
//                 int changes= (j-i+1)- maxfreq;

//                 if(changes<=k){
//                     maxlen= Math.max(maxlen, j-i+1);
//                 }

//                 else{
//                     break;
//                 }
//             }

//         }

// return maxlen;        
//     }
// }

class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int right=0;
        int maxlen=0;
        int maxfreq=0;

        int[] hash= new int[256];
        while(right<s.length()){
            hash[s.charAt(right)-'A']++;

            maxfreq= Math.max(maxfreq, hash[s.charAt(right)-'A']);

            while((right-left+1)- maxfreq>k){
                hash[s.charAt(left)-'A']--;

                left++;
            }

            maxlen= Math.max(maxlen, right-left+1);
            right++;
        }

        return maxlen;
    }}