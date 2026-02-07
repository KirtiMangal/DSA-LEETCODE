class Solution {
    public int minimumDeletions(String s) {
        int count = 0;
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') 
            {
                count++;
            } 
            
            else { 
                deletions = Math.min(deletions + 1, count);
            }
        }

        return deletions;
    }
}
