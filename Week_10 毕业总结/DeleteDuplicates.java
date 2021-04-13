public class DeleteDuplicates{

    public ListNode deleteDuplicates(ListNode head) {
        //思路二：题解 代码更加的简洁，学习一下；
        ListNode node = head;
        while(node != null && node.next != null){
            if(node.val == node.next.val) node.next = node.next.next;
            node = node.next;
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        //思路一次遍历记录一个区间的头部，与头部相同的元素都删除，直到下一个不同的元素重新记为头部；时间复杂度为O(n),空间复杂度O(1)
        ListNode node = head;
        ListNode preNode = null;
        while(node != null){
            if(preNode != null && preNode.val == node.val){
                preNode.next = node.next;
            }else{
                preNode = node;
            }
            node = node.next;
        }
        return head;
    }
}
