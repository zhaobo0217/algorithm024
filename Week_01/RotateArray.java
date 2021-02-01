class RotateArray {
      pulic void rotate(int[] nums, int k) {
        if (nums == null || k <= 0) return;
        //方法3：环形旋转；将当前位置index直接移动到到 （index + k）mod n 位置，依次移动；
        //但是当k与n存在非1公约数的话，会形成环；加入一个boolean[]记录出现过的index，如果有环的话移动到下一个元素；时间复杂度O(n),空间复杂度O(n);
        int index = 0;
        int hold = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) hold = nums[i];
            index = (index + k) % nums.length;
            if (visited[index] == true) {
                index = (index + 1) % nums.length;
                hold = nums[index];
                i--;
                continue;
            }
            visited[index] = true;
            int temp = nums[index];
            nums[index] = hold;
            hold = temp;
        }
    }

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
