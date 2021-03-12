public class NTreePreOrder{

    public List<Integer> preorder(Node root) {
        //时间复杂度为数的深度，空间复杂度为层级最大节点个数
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> record = new Stack<>();
        record.push(root);
        while(!record.isEmpty()){
            Node node = record.pop();
            res.add(node.val);
            List<Node> childNodes = node.children;
            if(childNodes != null){
                for(int i = childNodes.size() - 1; i >= 0; i--){
                    Node child = childNodes.get(i);
                    if(child == null) continue;
                    record.push(child);
                }
            }
        }
        return res;
    }

    private void dfs(Node root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        List<Node> childNodes = root.children;
        if(childNodes == null) return;
        for(Node child : childNodes){
            dfs(child, res);
        }
    }
}
