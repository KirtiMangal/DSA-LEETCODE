class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        HashMap<Character,Integer> map= new HashMap<>();
        int i=0;
        int max=0;

        for(int j=0; j<n; j++){
            char c= s.charAt(j);

            if(map.containsKey(c)){
                i= Math.max(map.get(c)+1, i);
            }

            map.put(c,j);

            max= Math.max(max, j-i+1);

        }

        return max;
    }
}