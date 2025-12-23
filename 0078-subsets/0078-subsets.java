class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n= nums.length;

        List<List<Integer>> result= new ArrayList<>();
        generate(0,nums, new ArrayList<>(), result);
        return result;
    }

public void generate(int idx, int[] nums, List<Integer> current, List<List<Integer>> result){

    int n= nums.length;
    if(idx==n){
        result.add(new ArrayList<>(current));
        return;
    }

    current.add(nums[idx]);
    generate(idx+1,nums,current,result);

    current.remove(current.size()-1);
    generate(idx+1,nums,current,result);
}
}