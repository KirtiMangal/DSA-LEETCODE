class Solution {
    public String removeDuplicates(String s, int k) {
        int n= s.length();
        if(s==null || n==0){
            return "";
        }

        if(k<=1){
            return "";
        }

        Stack<int[]> st= new Stack<>();

        for(char ch: s.toCharArray()){
            if(!st.isEmpty() && st.peek()[0]==ch){
                st.peek()[1]++;

                if(st.peek()[1]==k){
                    st.pop();
                }
            }

            else{
                st.push(new int[]{ch,1});
            }
        }

        StringBuilder sb= new StringBuilder();
        for(int[] p:st){
            for(int i=0;i<p[1];i++){
                sb.append((char) p[0]);
            }
        }

        return sb.toString();
    }
}