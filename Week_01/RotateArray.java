class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || k <= 0) return;
        //方式1: 新建一个数组，通过偏移将值赋给新数组，新数组结果即为旋转结果
        //时间复度为O(n)，空间复杂度为O(n)
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
    }

    public void rotate1(int[] nums, int k) {
        if (nums == null || k <= 0) return;
        //方式2：通过循环嵌套，记录尾部元素，其余元素向后移动；
        //时间复杂度为O(kn),空间复杂度为O(1);
        for (int i = 0; i < k; i++) {
            int tail = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j+1] = nums[j];
            }
            nums[0] = tail;
        }
    }
}
