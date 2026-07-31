class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first= strs[0];
        int n= first.length();
        int m= strs.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==strs[j].length() || (strs[j].charAt(i)!=first.charAt(i))){
                    return first.substring(0,i);
                }
            }
        }

        return first;
    }
}