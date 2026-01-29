class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n= strs[0].length();
        for(int i=0;i<n;i++){
            char ch= strs[0].charAt(i);

            int m= strs.length;
            for(int j=1;j<m;j++){
                if(i==strs[j].length() || strs[j].charAt(i)!=ch){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}