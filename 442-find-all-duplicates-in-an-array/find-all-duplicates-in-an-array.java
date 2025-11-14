class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
       
       List<Integer> duplicates= new ArrayList<>();
       Set<Integer> added= new HashSet<>();

       for(int num:nums){
        if(map.get(num)>1 && !added.contains(num)){
            duplicates.add(num);
            added.add(num);
        }
       }

       return duplicates;
        
    }
}



   

    
   
 