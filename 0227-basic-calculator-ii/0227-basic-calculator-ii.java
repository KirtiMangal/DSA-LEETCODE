class Solution {
    public int calculate(String s) {
        int n= s.length();

        if(s==null || n==0){
            return 0;
        }

        int lastNum=0;
        int currNum=0;
        char operator= '+';
        int result=0;

        for(int i=0;i<n;i++){
            char ch= s.charAt(i);

        if(Character.isDigit(ch)){
            currNum= currNum*10 +(ch-'0');
        }

        if((!Character.isDigit(ch) && ch!=' ')|| i==n-1){
            
        if(operator=='+'){
            result+= lastNum;
            lastNum= currNum;
        }

        else if(operator=='-'){
            result+= lastNum;
            lastNum= -currNum;
        }

        else if(operator=='*'){
            lastNum*= currNum;
        }

        else if(operator=='/'){
            lastNum/= currNum;
        }

        operator= ch;
        currNum=0;
        
    }}

return result + lastNum;
}}