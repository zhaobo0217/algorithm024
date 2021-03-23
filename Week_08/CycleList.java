public class CycleList{

    //这道题应该有两种方式，第一种使用hash表，存储之前的每个节点，新的节点中如果存在当前节点的next代表存在环，时间复杂度为O(n),空间复杂度使用到了hash表也为O(n);下面使用第二种方式，快慢指针，如果快指针追上了慢指针证明存在环，不然快指针到了最后，则没有环，时间复杂度O(n),空间复杂度为O(1)
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
