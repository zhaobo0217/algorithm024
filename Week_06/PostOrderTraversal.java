public class PostOrderTraversal{

    //尝试了一种新的写法
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //一种新的思路，反向入栈，最后反转结果，时间复杂度O(logn~n + n)，应该为O(n),空间复杂度最差为O(n)
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || root.right == preNode){
                res.add(root.val);
                preNode = root;
                root = null;
            }else{
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
