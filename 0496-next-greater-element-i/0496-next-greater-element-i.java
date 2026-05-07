class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[] res= new int[n1];

        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n2;i++){
            map.put(nums2[i],i);
        }

        for(int i=0;i<n1;i++){
            for(int j=map.get(nums1[i])+1;j<n2;j++){
                if(nums2[j]>nums1[i]){
                    res[i]=nums2[j];
                    break;
                }
            }
        }

        for(int i=0;i<res.length;i++){
            if(res[i]==0){
                res[i]-=1;
            }
        }

        return res;
        
    }
}