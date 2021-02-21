public class InOrderTravelsal {
    //中序遍历，对于二叉树的遍历一般可分为深度优先遍历和广度有先遍历；
    public List<Integer> interOrder(TreeNode root) {
	//深度优先一般使用递归的方式，时间空间复杂度都为O(n)
	List<Integer> result = new ArrayList<>();
	inorder(root, result);
	return result;
    }
    
    private void inorder (TreeNode root, List<Integer> collection) {
	if (root == null) return ;
	inorder(root.left, collection);
	collection.add(node);
	inorder(root.right, collection);
    }

    private void preOrder(TreeNode root, List<Integer> collection){
	if(root == null) return ;
	//前序遍历
	collection.add(root);
	preOrder(root.left, collection);
	preOrder(root.right, collection);
   }

   pivate void postOrder(TreeNode root, List<Integer> result) {
	if (root == null) return;
	postOrder(root.left,result);
	postOrder(root.right,result);
	result.add(root.val);//后序遍历
   }
	
    public List<Integer> inorderTravelsal(TreeNode root) {
	//广度优先一般需要借助栈的方式，时间复杂度遍历需要每个节点，为O(n)，空间复杂度为O(n + k);其中k为数的深度，不急常数也为O(n),比递归的方式多了栈的空间;
	List<Integer> result = new ArrayList<>();
	Stack<Integer> record = new Stack<>();
	while (root != null || !stack.isEmpty()) {
	    while (root != null) {
		record.push(root);
		root = root.left;	
	    }
	    root = record.pop;
	    result.add(root.val);
	    root = root.right;
	}
	return result;
    }

  public List<Integer> preTravelsal(TreeNode root) {
	List<Integer> result = new ArrayList<>();
	Stack<Integer> stack = new Stack<>();
	while (root != null || !stack.isEmpty()) {
	    
	}
  }
}
