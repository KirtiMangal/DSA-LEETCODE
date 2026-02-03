class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high= getMax(piles);
        int answer= high;

        while(low<=high){
            int mid= low+(high-low)/2;

            if(canFinish(piles,mid,h)){
                answer=mid;
                high= mid-1;
            }
            else{
            low= mid+1;
        }
        }
    return answer;
    }


public int getMax(int[] piles){
    int max= piles[0];
    for(int pile: piles){
        max= Math.max(max,pile);
    }

    return max;
}

public boolean canFinish(int[] piles, int k,int h){
    long totalhrs=0;

    for(int pile:piles){
        totalhrs+= (pile+k-1)/k;
    }

    return totalhrs<=h;
}
}