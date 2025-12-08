class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n= g.length;
        int m= s.length;
        int i=0;
        int j=0;

        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;

        while(i<n && j<m){
            if(s[j]>=g[i]){
                i++;
                count++;
            }
            j++;
        }

        return count;
    }

}