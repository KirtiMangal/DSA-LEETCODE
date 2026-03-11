// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n= s.length();
//         int left=0;
//         int max=0;

//         HashMap<Character,Integer> map= new HashMap<>();
//         for(int right=0;right<n;right++){
//             char ch= s.charAt(right);

//             if(map.containsKey(ch)){
//                 left= Math.max(map.get(ch)+1, left);
//             }

//             map.put(ch,right);
//             max= Math.max(max, right-left+1);
//         }

//         return max;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        int left=0;
        int max=0;

        Set<Character> set= new HashSet<>();
        for(int right=0;right<n;right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            max= Math.max(max, right-left+1);
        }

        return max;
    }}