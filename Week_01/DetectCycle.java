public class DetectCycle {

  public ListNode detectCycle(ListNode head) {
      //这题有一个数学逻辑的推理。建议画图重推一下，结论是当快慢指针相遇后，在重新弄一个指针从头开始，与慢指针一块移动直到相同后返回
      ListNode slow = head;
      ListNode fast = head;
      while (slow != null && fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
          if(slow  == fast){
              ListNode pre = head;
              while (slow != pre) {
                  slow = slow.next;
                  pre = pre.next;
              }
              return slow;
          }
      }
      return null;
  }
}
