class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        int i=0;
        int max=0;

        HashMap<Character,Integer> map= new HashMap<>();

        for(int j=0;j<n;j++){
           char ch= s.charAt(j);

           if(map.containsKey(ch)){
            i= Math.max(map.get(ch)+1, i);
           }

           map.put(ch,j);
           max= Math.max(max, j-i+1);
        }

        return max;
    }
}