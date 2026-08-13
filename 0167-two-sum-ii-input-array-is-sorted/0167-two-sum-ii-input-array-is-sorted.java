class Solution {
    public int[] twoSum(int[] numbers, int target) {
         int n= numbers.length;
        HashMap<Integer,Integer> map= new HashMap<>();

        for(int i=0;i<n;i++){
            int required= target-numbers[i];

            if(map.containsKey(required)){
                return new int[]{map.get(required),i+1};
            }

            map.put(numbers[i],i+1);
        }

        return new int[]{};
    }
}