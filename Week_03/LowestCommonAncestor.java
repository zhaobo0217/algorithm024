class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //第二种解题思路是，一般为三种情况，第一种两个节点分布在父节点两侧，那么父节点为最近公共节点，要么分布在一侧，那么最先找到的即为最近父节点；
        //时间复杂度为树的深度最差为O(n),平均为O(logn);
        //空间复杂度为数的深度，最差也为O(n),为一个链表
        if (root == null || p.val == root.val || q.val == root.val) return root;
         TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
         TreeNode rightNode = lowestCommonAncestor(root.right,p,q);
         if(leftNode == null && rightNode == null){
             return null;
         }else if(leftNode == null) {
             return rightNode;
         }else if(rightNode == null) {
             return leftNode;
         }else {
             return root;
         }
    }

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //第一种比较容易想到的解法：元素的值不会相同，可以建一个HashMap，存储当前节点值和父节点，然后从要寻找的某个子节点向上寻找父节点并存储父节点的值，然后寻找另外一个节点父节点，如果有相同的的话即代表他们有共同的父节点；
        //时间复杂度，通过dfs，存储节点父节点为O(n),存储p节点父节点信息，时间复杂度为p的深度为O(p),同理q为O(q);最差为O(3n),最好为O(n);即为O(n);
        //空间复杂度，需要一个hashMap来存储元素为O(n),一个set来存储p节点索引为p的深度O(p),递归最坏为O(n);最终为O(n);
        HashMap<Integer, TreeNode> nodeMap = new HashMap<>();
        dfs(root, nodeMap);
        Set<Integer> set = new HashSet<>();
        while (p != null) {
            set.add(p.val);
            p = nodeMap.get(p.val);
        }
        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }
            q = nodeMap.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode node, HashMap<Integer, TreeNode> map) {
        if (node == null) return;
        TreeNode left = node.left;
        if(left != null){
            map.put(left.val, node);
            dfs(left, map);
        }
        TreeNode right = node.right;
        if(right != null) {
            map.put(right.val, node);
            dfs(right, map);
        }
    }

}
