class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n= s.length();
        List<String> ans= new ArrayList<>();

        for(int i=1;i<4 && i<n;i++){
            for(int j=i+1;j<i+4 && j<n;j++){
                for(int k=j+1;k<j+4 && k<n;k++){
                    String a= s.substring(0,i);
                    String b= s.substring(i,j);
                    String c= s.substring(j,k);
                    String d= s.substring(k);

                    if(isValid(a) && isValid(b) && isValid(c) && isValid(d)){
                    ans.add(a + "." + b + "." + c + "." + d);

                    }
                }
            }
        }

        return ans;
        
    }

    public static boolean isValid(String part){
        if(part.length()==0 || part.length()>3)
        return false;

        if(part.length()>1 && part.charAt(0)=='0')
        return false;

        int val= Integer.parseInt(part);
        return val>=0 && val<=255;
    }
}