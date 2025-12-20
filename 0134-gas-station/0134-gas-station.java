class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n= gas.length;
        int totalgas=0;
        int totalcost=0;

        for(int i=0;i<n;i++){
            totalgas+= gas[i];
            totalcost+= cost[i];
        }

            if(totalgas<totalcost){
                return -1;
            }

            int currentgas=0;
            int startIdx=0;

            for(int i=0;i<n;i++){
                currentgas+= gas[i]-cost[i];

                if(currentgas<0){
                    startIdx= i+1;
                    currentgas=0;
                }
            }

            return startIdx;
        }
}

