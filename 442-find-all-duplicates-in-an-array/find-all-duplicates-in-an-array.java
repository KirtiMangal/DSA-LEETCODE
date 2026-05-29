class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n= nums.length;

        List<Integer> list= new ArrayList<>();
        HashSet<Integer> set= new HashSet<>();

        for(int i=0;i<n;i++){
        if(set.contains(nums[i])){
            list.add(nums[i]);
        }

        else{
            set.add(nums[i]);
        }
        }

        return list;
    }
}