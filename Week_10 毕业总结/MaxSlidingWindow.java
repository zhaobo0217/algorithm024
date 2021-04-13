public class MaxSlidingWindow{

    public int[] maxSlidingWindow(int[] nums, int k) {
        //之前已经知道思路，但本此还是花了十几分钟推导；所有的问题都需要总结：1、建立双端队列存储索引；2、循环如果当前元素大于队尾元素，移除队尾元素；添加当前元素到队尾；3、如果队首元素已经超出窗口移除i - peekFirst + 1 > k;4、当前索引大于窗口值，添加队首元素到结果列表；时间复杂度O(n),空间复杂度O(1)
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(i - deque.peekFirst() + 1 > k){
                deque.removeFirst();
            }
            if(i + 1 >= k){
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
