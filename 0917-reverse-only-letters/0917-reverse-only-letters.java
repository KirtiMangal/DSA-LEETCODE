class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr= s.toCharArray();
        int n= s.length();
        int left=0;
        int right= n-1;

        while(left<right){
            if(!Character.isLetter(arr[left])){
                left++;
                continue;
            }

            if(!Character.isLetter(arr[right])){
                right--;
                continue;
            }

            char ch= arr[left];
            arr[left]= arr[right];
            arr[right]= ch;

            left++;
            right--;
        }

        return new String(arr);
    }
}