class Solution {
    public int search(int[] nums, int target) {
        int n= nums.length;

        int pivot = findPivot(nums);

        if(target>=nums[pivot] && target<=nums[n-1]){
            return binarySearch(nums,pivot,n-1,target);
        }

        else{
            return binarySearch(nums,0,pivot-1,target);
        }
    }

        private int findPivot(int[] nums){
            int n= nums.length;
            int low=0;
            int high= n-1;
            while(low<high){
                int mid= low+(high-low)/2;

                if(nums[mid]>nums[high]){
                    low=mid+1;
                }

                else{
                    high=mid;
                }
            }

            return low;
        }

        private int binarySearch(int[] nums, int low,int high, int target){
            while(low<=high){
                int mid= low+(high-low)/2;

                if(nums[mid]==target){
                    return mid;
                }

                else if(nums[mid]<target){
                    low=mid+1;
                }

                else{
                    high=mid-1;
                }
            }

            return -1;
        }
    }