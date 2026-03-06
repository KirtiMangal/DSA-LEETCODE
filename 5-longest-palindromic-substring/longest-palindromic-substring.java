class Solution {
    public String longestPalindrome(String s) {
        int n= s.length();

        if(s == null || n < 1) 
        return "";

        int start = 0;
        int end = 0;

        for(int i = 0; i < n; i++){
            int len1 = expand(s, i, i);     // odd length
            int len2 = expand(s, i, i + 1); // even length
            int len = Math.max(len1, len2);

            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right){
        int n= s.length();
        while(left >= 0 && right <n  && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}