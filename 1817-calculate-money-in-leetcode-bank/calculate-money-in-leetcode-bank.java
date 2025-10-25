class Solution {
    public int totalMoney(int n) {
        int total=0;

        for(int day=1;day<=n;day++){
            int week= (day-1)/7;
            int dayOfWeek= (day-1)%7;
             total+= week+ dayOfWeek+1;
        }

        return total;
        
    }
}