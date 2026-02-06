class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n= weights.length;
        int low=0;
        int high=0;

        for(int weight: weights){
            low= Math.max(low,weight);
            high+= weight;
        }


            while(low<=high){
                int mid= low+(high-low)/2;

                int day=1;
                int sum=0;

                for(int weight: weights){
                    if(sum+ weight>mid){
                        day++;
                        sum= weight;
                    }
                    else{
                        sum+= weight;
                    }
                }

                if(day>days){
                    low= mid+1;
                }

                else{
                    high= mid-1;
                }
            }
                return low;
            }
        }