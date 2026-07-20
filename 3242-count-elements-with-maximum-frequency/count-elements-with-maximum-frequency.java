class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n= nums.length;
        int max=0;

        Map<Integer,Integer> map= new HashMap<>();
        for(int num:nums){
            int freq= map.getOrDefault(num,0)+1;
            map.put(num,freq);
            max= Math.max(max,freq);
     }

     int total=0;
     for(int freq: map.values()){
        if(freq==max){
            total+= freq;
        }

     }
     return total;
       
    }
}