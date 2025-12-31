class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if(root==null)
        return result;

        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        boolean zigzag= true;

        while(!q.isEmpty()){
            int levelSize= q.size();

            List<Integer> currentlevel= new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode current= q.poll();

                if(zigzag){
                currentlevel.add(current.val);
                }

                else{
                    currentlevel.add(0,current.val);
                }

                if(current.left!=null){
                    q.add(current.left);
                }

                if(current.right!=null){
                    q.add(current.right);
                }
         
            } 

            result.add(currentlevel);
            zigzag=!zigzag;
        }

        return result;
    }
}