class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n= graph.length;
        int[] state= new int[n];
        List<Integer> result= new ArrayList<>();

        for(int i=0;i<n;i++){
            if(isSafe(graph,state,i)){
                result.add(i);
            }
        }

    return result;
}

private boolean isSafe(int[][] graph,int state[],int node){
    if(state[node]!=0){
        return state[node]==2;
    }

    state[node]=1;

    for(int neighbour:graph[node]){
        if(!isSafe(graph,state,neighbour)){
            return false;
        }
    }

    state[node]=2;

    return true;
}
}


       