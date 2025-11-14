class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->b[1]-a[1]);

        int total=0;

        for(int[] box: boxTypes){
            int numBoxes= box[0];
            int unitsperBox= box[1];

            if(truckSize==0)
            break;

            int takeBoxes= Math.min(truckSize, numBoxes);

            total+= takeBoxes*unitsperBox;
            truckSize-= takeBoxes;
        }

        return total;
        
    }
}