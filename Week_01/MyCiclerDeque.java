public class MyCyclerDeque {
  private int size = 0;
    private int maxSize;
    private Node head = new Node(0);
    private Node tail =  new Node(0);
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.maxSize = k;
        head.next = tail;
        tail.pre = head;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        Node next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
        ++size;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        Node pre = tail.pre;
        tail.pre = node;
        node.next = tail;
        pre.next = node;
        node.pre = pre;
        ++size;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (head.next != tail) {
            Node node = head.next.next;
            head.next = node;
            node.pre = head;
            --size;
            return true;
        }
        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (tail.pre != head) {
            Node pre = tail.pre.pre;
            tail.pre = pre;
            pre.next = tail;
            --size;
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head.next != tail ? head.next.value : -1;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return tail.pre  != head ? tail.pre.value : -1;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size >= maxSize;
    }

    class Node {
        int value;
        Node next;
        Node pre;

        public Node(int value) {
            this.value = value;
        }
    }
}
