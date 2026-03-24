class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words= s.split(" ");

        int n= pattern.length();
        int m= words.length;

        if(n!=m){
            return false;
        }

        Map<Character,String> map1= new HashMap<>();
        Map<String,Character> map2= new HashMap<>();

        for(int i=0;i<n;i++){
            char c1= pattern.charAt(i);
            //char c2= s.charAt(i);
            String c2= words[i];

            if(map1.containsKey(c1) && !map1.get(c1).equals(c2)){
                return false;
            }

            if(map2.containsKey(c2) && map2.get(c2)!=c1){
                return false;
            }

            map1.put(c1,c2);
            map2.put(c2,c1);
        }

        return true;


    }
}