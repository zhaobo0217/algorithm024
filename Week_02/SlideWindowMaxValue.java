class SlideWindowMaxValue {
		
   public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<>();
	//基本思路是声明一个双端队列，头部放最大值，当头部索引小于窗口值，移除头部；否则在窗口范围内取出头部元素即为窗口最大值；时间复杂度O(n),空间复杂度O(N)
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i< nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() == (i - k)){
                //到达窗体最大值
                deque.pollFirst();
            }
            if(i >= k -1){
                result[index++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || k < 0 || nums.length == 0) return new int[0];
        int index = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            int subMax = subMax(nums, i, i + k);
            nums[index++] = subMax;
        }
        return Arrays.copyOfRange(nums, 0, index);
    }

    private int subMax(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        while (l < r) {
            max = Math.max(max, nums[l++]);
        }
        return max;
    }

}
