public class NTreePostOrder{

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node == null) continue;
            res.add(node.val);
            List<Node> childNodes = node.children;
            if(childNodes == null) continue;
            for(Node child : childNodes){
                if(child != null) stack.push(child);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
