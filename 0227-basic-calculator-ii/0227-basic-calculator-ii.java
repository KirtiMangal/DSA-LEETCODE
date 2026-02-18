class Solution {
    public int calculate(String s) {
        int n= s.length();
        if(s==null || n==0){
            return 0;
        }

     Stack<Integer> st= new Stack<>();

        int currNum=0;
        char operator='+';

        for(int i=0;i<n;i++){
            char ch= s.charAt(i);
        
        if(Character.isDigit(ch)){
            currNum= currNum*10 + (ch-'0');
        }

        if((!Character.isDigit(ch) && ch!=' ') || i==n-1){

        if(operator=='+'){
            st.push(currNum);
        }

        else if(operator=='-'){
            st.push(-currNum);
        }

        else if(operator=='*'){
            st.push(st.pop()*currNum);
        }

        else if(operator=='/'){
            st.push(st.pop()/currNum);
        }

        operator= ch;
        currNum=0;
    }
}

int result=0;

while(!st.isEmpty()){
    result+= st.pop();
}

return result;
}
}