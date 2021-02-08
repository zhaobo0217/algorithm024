public class MoveZeros {

    public void moveZeroes(int[] nums) {
        //时间复杂度O(n),空间复杂度O(1)
        if (nums == null) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        if (nums == null) return;
        int index = 0;
        //时间复杂度O(n + k) = O(n),大于第一种,空间复杂度O(1)
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
