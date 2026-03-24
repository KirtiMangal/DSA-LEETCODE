import java.util.*;
class Solution {
    public String frequencySort(String s) {
        int n= s.length();
        
        //Count frequency 

        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            char ch= s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        //List formation

        List<Character> list= new ArrayList<>(map.keySet());

        // Sorting

        Collections.sort(list, (a,b)->map.get(b)-map.get(a));

        // Result formation

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<list.size();i++){

            char ch= (list.get(i));
            int freq= map.get(ch);

            while(freq-->0){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}