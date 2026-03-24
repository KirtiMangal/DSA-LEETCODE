class Solution {
    public String frequencySort(String s) {
        int n= s.length();
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            char ch= s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        List<Character> list= new ArrayList<>(map.keySet());

        Collections.sort(list,(a,b)->map.get(b)-map.get(a));

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<list.size();i++){
            char ch= list.get(i);
            int freq= map.get(ch);

            while(freq-->0){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}