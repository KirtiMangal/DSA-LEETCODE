class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;

        // Initial penalty: shop closed all day
        for (char c : customers.toCharArray()) {
            if (c == 'Y') 
            penalty++;
        }

        int minPenalty = penalty;
        int bestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;   // customer came, shop open is good
            } 
            
            else {
                penalty++;   // no customer, shop open is bad
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }
}
