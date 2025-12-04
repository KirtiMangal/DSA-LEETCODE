import java.util.*;

class Solution {
    public String removeDuplicates(String s) {

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {

            // if last char is same → remove it
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);   // remove last
                map.remove(c);                      // remove from map
            } 
            else {  
                sb.append(c);                       // add new char
                map.put(c, 1);                      // store freq=1
            }
        }

        return sb.toString();
    }
}
