public class MaxDepth {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        //广度优先时间复杂度O(N),空间复杂度最大队列size
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int index = queue.size();
            while (index > 0) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(left != null){
                    queue.offer(left);
                }
                if(right != null){
                    queue.offer(right);
                }
                index--;
            }
            depth++;
        }
        return depth;
    }

    public int maxDepth1(TreeNode root) {
        //深度优先，时间复杂度O(n)
        if (root == null) return 0;
        return Math.max(maxDepth1(root.left),maxDepth1(root.right)) + 1;
    }
}
