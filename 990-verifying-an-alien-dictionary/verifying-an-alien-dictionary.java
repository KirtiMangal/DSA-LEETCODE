class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n=order.length();
        int m=words.length;

        int[] map= new int[26];
        for(int i=0;i<26;i++){
            map[order.charAt(i)-'a']=i;
        }
        
        for(int i=0;i<m-1;i++){
            if(!isSorted(words[i],words[i+1],map)){
                return false;
            }
        }

        return true;
    }

public boolean isSorted(String s1, String s2,int[] map){

    int len= Math.min(s1.length(),s2.length());

    for(int i=0;i<len;i++){
        int w1= s1.charAt(i);
        int w2= s2.charAt(i);

        if(w1!=w2){
            return map[w1-'a']< map[w2-'a'];
        }
    }

    return s1.length()<=s2.length();
}
}