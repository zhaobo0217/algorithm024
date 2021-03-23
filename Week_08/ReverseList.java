public class ReverseList{

    //两种方式：递归时间复杂度O(n),空间复杂度O（n）递归深度
    public ListNode reverseList(ListNode head){
        return recursion(head, null);
    }

    //迭代时间复杂度O(n),空间复杂度O(1)
    public ListNode reverseList1(ListNode head) {
        ListNode preNode = null;
        ListNode node = head;
        while(node !=null){
            ListNode next = node.next;
            node.next = preNode;
            preNode = node;
            node = next;
        }
        return preNode;
    }

    public ListNode recursion(ListNode node, ListNode preNode){
        if(node == null) return preNode;
        ListNode next = node.next;
        node.next = preNode;
        return recursion(next, node);
    }
}
