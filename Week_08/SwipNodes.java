public class SwipNodes{

    public ListNode swapNodes(ListNode head, int k) {
        //定义一个步长，即K 等于k，代表前K个数，大于K的话，更新后K为后K的next；时间复杂度为O(n),空间复杂度为O(1);方法二：使用双端队列，放K个值，循环结束，取出first即为后K
        if(k <= 0) return head;
        ListNode node = head;
        ListNode kNode = null;
        ListNode antiKNode = node;
        int index = 1;
        while(node != null){
            if(index == k){
                kNode = node;
            }else if(index > k){
                antiKNode = antiKNode.next;
            }
            node = node.next;
            index++;
        }
        if(kNode != null && antiKNode != null){
            int temp = kNode.val;
            kNode.val = antiKNode.val;
            antiKNode.val = temp;
        }
        return head;
    }
}
