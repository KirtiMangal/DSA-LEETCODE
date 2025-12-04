class Solution {
    public String removeDuplicates(String s) {

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {

            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);   
                map.remove(c);                      
            } 

            else 
            {  
                sb.append(c);                    
                map.put(c, 1);                     
            }
        }

        return sb.toString();
    }
}
