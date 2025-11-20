class Solution {
    public boolean binarySearch(int[] nums,int target){
        int n= nums.length;
        int left=0;
        int right=n-1;

        while(left<=right){
            int mid= left+(right-left)/2;

            if(nums[mid]==target){
                return true;
            }

            else if(nums[mid]<target){
                left=mid+1;
            }

            else{
                right=mid-1;
            }
        }

        return false;
    }

    public int getLargestOutlier(int[] nums) {
        Arrays.sort(nums);
        
        int totalSum= Arrays.stream(nums).sum();
        Map<Integer,Integer> map= new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int n= nums.length;

        for(int i=n-1; i>=0;i--){
            double potentialSum= (totalSum-nums[i])/2.0;

             if (potentialSum % 1 != 0) 
             
             continue;
            int target = (int) potentialSum;

            if (binarySearch(nums, target)) {

        if ((potentialSum == nums[i] && map.get(nums[i]) >= 2) 
                    || potentialSum != nums[i]) 
                {
                    return nums[i];
                }
            }
        }

        return 0; 
    }
}

           