class Solution {
    public int evalRPN(String[] arr) {
        Stack<Integer> st= new Stack<>();

        for(String ar:arr){
            if(ar.equals("+") || ar.equals("-") || ar.equals("*") || ar.equals("/") || ar.equals("^")){
                int b= st.pop();
                int a= st.pop();

                switch(ar){
                    case "+":
                    st.push(a+b);
                    break;

                    case "-":
                    st.push(a-b);
                    break;

                    case "*":
                    st.push(a*b);
                    break;

                    case "/":
                    st.push(a/b);
                    // st.push(Math.floorDiv(a,b));
                    break;

                    case "^":
                    st.push(a^b);
                }
            }

            else{
                st.push(Integer.parseInt(ar));
            }
        }

        return st.pop();
    }
}