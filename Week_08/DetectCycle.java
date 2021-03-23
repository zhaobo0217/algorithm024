public class DetectCycle{

    public ListNode detectCycle(ListNode head) {
        //这题当然也可以使用hash表，题目要求使用O(1)的空间复杂度，比较容易我们可以想到快慢指针，快慢指针难点在于寻找首节点，画图a为首节点到入环点，b为入环点到相遇点，c为相遇点到入环点，s(fast) = a + n(b + c) + b,S(slow) = a + b --> s(fast) == 2s(slow)-> a = (n - 1)b + c;a是我们需要的结果。我们可以在相遇时新建一个节点，让他与slow一块走，最终相遇在入口；不堪题解，我实在想不到
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            slow = slow.next;
            if(fast.next != null) fast = fast.next.next;
            else return null;
            if(slow == fast){
                //相遇点
                ListNode pre = head;
                while(pre != slow){
                    slow = slow.next;
                    pre = pre.next;
                }
                return pre;
            }
        }
        return null;
    }
}
