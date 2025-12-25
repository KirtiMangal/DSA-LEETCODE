class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }

        String concatenate= s+s;
        return concatenate.contains(goal);
    }
}