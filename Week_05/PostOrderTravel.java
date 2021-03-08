public class PostOrderTravel{

    public List<Integer> postorderTraversal(TreeNode root){
        //第一种比较容易理解的递归方式时间复杂度为O(n),空间复杂度最坏为链O(n),最好为O(logN)
        List<Integer> res = new ArrayList<>();
        postorderRecursion(root, res);
        return res;
    }

    private void postorderRecursion(TreeNode root, List<Integer> res){
        if(root == null) return;
        postorderRecursion(root.left, res);
        postorderRecursion(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        //后序遍历的递归方式比较容易理解,迭代法需要借助栈结构，一般步骤，第一步将所有的左节点入栈；第二步拿出栈顶节点，跟据先、中、后顺序添加右侧节点；后序比其他麻烦，需要记住前一个遍历节点，时间复杂度应该为节点数+父节点数（这个入栈2此）总之也为O(n),空间复杂度为栈深度，最差为O(n)
        List<Integer> res = new ArrayList<>();
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
