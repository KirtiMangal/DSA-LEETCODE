class Solution {
    public boolean checkOnesSegment(String s) {
        int count = 0;
        int n= s.length();

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1' && (i == 0 || s.charAt(i-1) == '0')){
                count++;
            }
            
            if(count > 1) 
            return false;
        }

        return true;
    }
}