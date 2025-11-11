class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n= graph.length;
        int[] state= new int[n];
        List<Integer> result= new ArrayList<>();

        for(int i=0;i<n;i++){
            if(isSafe(i,graph,state)){
                result.add(i);
            }
        }

        return result;
}

private boolean isSafe(int node,int[][] graph,int[] state){
    if(state[node]!=0){
        return state[node]==2;
    }

    state[node]=1;

    for(int neighbour:graph[node]){
        if(!isSafe(neighbour,graph,state)){
            return false;
        }
    }

    state[node]=2;
    return true;
}
}