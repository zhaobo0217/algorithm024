public class MaxSlidingWindow{
    //利用双向单调队列，存储数组单调索引，当头部索引小于窗口边界的话，移除头部元素，否则将头部元素添加到返回集合中，时间复杂度O(n),空间复杂度O(1);
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            int left = i - k + 1;
            if(deque.peekFirst() < left){
                deque.pollFirst();
            }
            if(left >= 0){
                res[left] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
