class Solution {
    public int leastInterval(char[] tasks, int n) {

        int len= tasks.length;
        int[] freq= new int[26];
        

        for(int i=0;i<len;i++){
            freq[tasks[i]-'A']++;
        }

        int maxFreq=0;
        for(int i=0;i<26;i++){
            if(freq[i]>maxFreq){
                maxFreq= freq[i];
            }
        }

        int countMax=0;
        for(int i=0;i<26;i++){
            if(freq[i]==maxFreq){
                countMax++;
            }
        }

        int sub=  (maxFreq-1) * (n+1) + countMax;
        int ans;
        if(sub<len){
            ans=len;
        }

        else{
            ans= sub;
        }
        
        return ans;
    }
}