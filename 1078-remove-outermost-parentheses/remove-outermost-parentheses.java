class Solution {
    public String removeOuterParentheses(String s) {
        int n= s.length();
        Stack<Character> st= new Stack<>();
        StringBuilder sb= new StringBuilder();

        for(int i=0;i<n;i++){
            char ch= s.charAt(i);

            if(ch=='('){
                if(!st.isEmpty())
                    sb.append(ch);
                    st.push(ch);
            }

                else{
                    st.pop();
                    if(!st.isEmpty())
                        sb.append(ch);
                    }
                }

                return sb.toString();
            }
            }