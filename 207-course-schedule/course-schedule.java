class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int indegree[] = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>()); 
        }

        for(int[] pair: prerequisites){
            int a= pair[0];
            int b= pair[1];
            graph.get(b).add(a);
            indegree[a]++;
        }

            Queue<Integer> q= new LinkedList<>();
            for(int i=0;i<numCourses;i++){
                if(indegree[i]==0){
                q.offer(i);
            }
        }

            int completedCourses=0;
            while(!q.isEmpty()){
                int course= q.poll();
                completedCourses++;

                for(int neighbour: graph.get(course)){
                    indegree[neighbour]--;

                    if(indegree[neighbour]==0){
                        q.offer(neighbour);
                    }

                }
            }

            return completedCourses==numCourses;
        }
        
    }
