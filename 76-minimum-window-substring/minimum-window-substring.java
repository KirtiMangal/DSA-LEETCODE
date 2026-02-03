class Solution {
    public String minWindow(String s, String t) {
        int n= s.length();
        int m= t.length();

        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<m;i++){
            char ch= t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        int count= map.size();
        int startIdx= -1;
        int start=0;
        int end= 0;
        int len= Integer.MAX_VALUE;

        while(end<n){
            char ch= s.charAt(end);
            if(map.containsKey(ch)){
            map.put(ch,map.get(ch)-1);
            if(map.get(ch)==0){
                count--;
            }

            }
            while(count==0){
                int len1= end-start+1;
                if(len1<len){
                    len= len1;
                    startIdx= start;
                }

                ch= s.charAt(start);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);

                    if(map.get(ch)>0){
                        count++;
                    }
                }

                start++;
            }

            end++;
        }

        if(startIdx==-1){
            return "";
        }

        return s.substring(startIdx, startIdx+len);
        
    }
}