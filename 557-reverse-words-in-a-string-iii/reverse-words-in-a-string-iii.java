class Solution {
    public String reverseWords(String s) {
        String[] words= s.split(" ");
        StringBuilder result= new StringBuilder();

        int n= words.length;
        for(int i=0;i<n;i++){
            String word= words[i];
            StringBuilder reverseWord= new StringBuilder(word);
            result.append(reverseWord.reverse().toString()).append(" ");
        }

        return result.toString().trim();
    }
}