public class ReverseKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        ListNode hair  = new ListNode(0, head);
        ListNode pre = hair;
        ListNode cur = hair;
        while (cur.next != null) {
          //通过循环找到结束的节点反转前K个 反转后将链表再粘贴一下
            for (int i = 0; i < k && cur != null ; i++) {
                cur = cur.next;
            }
            //此处说明量不够了
            if (cur == null) break;
            ListNode start = pre.next;
            ListNode next = cur.next;
            //正常的反转链表
            pre.next = reverse(start, next);
            start.next = next;
            pre = start;
            cur = pre;
        }
        return hair.next;
    }

    private ListNode reverse(ListNode node,ListNode end) {
       ListNode pre = null;
       while (node != end) {
           ListNode next = node.next;
           node.next = pre;
           pre = node;
           node = next;
       }
        return pre;
    }
}
