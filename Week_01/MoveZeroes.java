class MoveZeros {
    //此题解法一：新建一个等长的数组，遍历中将非0元素一次填入数组，另外一端补0；
    //解法二：建一个指针记录非0元素下一个位置，将下一个非0元素赋给该值，最后将剩余位置赋值0；
    public void moveZeroes(int[] nums) {
   	if (nums == null) return;
	int index = 0;
	for (int i= 0; i < nums.length; i++) {
		if (nums[i] != 0) {
			nums[index++] = nums[i];
		}
	}
	while (index < nums.length) {
		nums[index++] = 0;
	}
    }
}

