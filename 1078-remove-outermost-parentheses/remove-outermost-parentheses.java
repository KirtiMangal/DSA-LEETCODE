// class Solution {
//     public String removeOuterParentheses(String s) {
//         int n= s.length();
//         Stack<Character> st= new Stack<>();
//         StringBuilder sb= new StringBuilder();

//         for(int i=0;i<n;i++){
//             char ch= s.charAt(i);

//             if(ch=='('){
//                 if(!st.isEmpty())
//                     sb.append(ch);
//                     st.push(ch);
//             }

//                 else{
//                     st.pop();
//                     if(!st.isEmpty())
//                         sb.append(ch);
//                     }
//                 }

//                 return sb.toString();
//             }
//             }


class Solution {
    public String removeOuterParentheses(String s) {
        int n= s.length();
        StringBuilder sb= new StringBuilder();
        int depth=0;

        for(int i=0;i<n;i++){
            char ch= s.charAt(i);

            if(ch=='('){
                if(depth>0){
                    sb.append(ch);
                }

                depth++;
            }

            else{
                depth--;
                if(depth>0){
                    sb.append(ch);
                }
            }

        }
            return sb.toString();
        }
        }