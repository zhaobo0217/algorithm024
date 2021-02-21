public class ReverseLinkedList {
    public int[]  reversePrint(ListNode head){
        //方法1：通过一个循环拿到链表的节点数，然后新建一个节点数长度的数组，循环赋值；两遍遍历时间复杂度为O(n)+O(n)=O(n);空间复杂度为O(n);
        if (head == null) return new int[0];
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        node = head;
        int[] result = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = node.val;
            node = node.next;
        }
        return result;
    }

    public int[] reversePrint1(ListNode head) {
        //方法2：解析数据存入一个栈中FILO，然后通过遍历栈拿到结果；也是两遍遍历时间复杂度为O(n),内存空间多了栈O(n),也为O(n)
        if (head == null) return new int[0];
        Stack<Integer> stack =  new Stack<>();
        ListNode node = head;
        while (node!=null) {
            stack.push(node.val);
            node = node.next;
        }
        int[] result = new int[stack.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = stack.pop();
        }
        return result;
    }
}
