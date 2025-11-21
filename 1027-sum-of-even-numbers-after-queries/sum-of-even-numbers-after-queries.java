class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n= queries.length;
        
        int[] answer = new int[n];

        int EvenSum = 0;
        for (int number : nums) {
            if (number % 2 == 0) {
                EvenSum += number;
            }
        }

        int result = 0;
        for (int[] query : queries) {
            int valueToAdd = query[0];
            int index = query[1];

            if (nums[index] % 2 == 0) {
                EvenSum -= nums[index];
            }

       
            nums[index] += valueToAdd;

          
            if (nums[index] % 2 == 0) {
                EvenSum += nums[index];
            }

            answer[result++] = EvenSum;
        }

        return answer;
    }
}
