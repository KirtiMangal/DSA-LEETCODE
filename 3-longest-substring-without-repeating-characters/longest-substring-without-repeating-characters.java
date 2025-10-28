// class Solution {
//     public int lengthOfLongestSubstring(String s) {

//         int n= s.length();
//         int maxLength=0;

//         HashMap<Character,Integer> map= new HashMap<>();
//         int left=0;

//         for(int right=0;right<n;right++){
//             char c= s.charAt(right);

//             if(map.containsKey(c)){
//                 left= Math.max(map.get(c)+1, left);
//             }

//             map.put(c,right);
//             maxLength= Math.max(maxLength,right-left+1);

//         }

//         return maxLength;
        
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        int maxLength=0;
        int[] lastIndex= new int[256];
        Arrays.fill(lastIndex,-1);

        int left=0;
        for(int right=0;right<n;right++){
            char c= s.charAt(right);

            if(lastIndex[c]!=-1){
                left= Math.max(left, lastIndex[c]+1);
            }

            lastIndex[c]= right;
            maxLength= Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }}