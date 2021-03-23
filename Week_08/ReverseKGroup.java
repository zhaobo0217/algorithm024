public class ReverseKGroup{

     //两种方式，一种使用栈，本质都是反转局部链表，需要记录局部的头。尾，连接下一个片段，时间复杂度为O(n),空间复杂度O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        if(head == null || k < 2) return head;
        Stack<ListNode> record= new Stack<>();
        ListNode tailNode = null;
        ListNode res = null;
        while(head != null){
            record.add(head);
            head = head.next;
            if(record.size() == k){
                while(!record.isEmpty()){
                    if(tailNode == null) {
                        tailNode = record.pop();
                        res = tailNode;
                    }else {
                        tailNode.next = record.pop();
                        tailNode = tailNode.next;   
                     }
                }
                tailNode.next = head;
            }
        }
        return res;
    }
}
