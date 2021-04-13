public class ProductExceptSelf{

    public int[] productExceptSelf(int[] nums) {
        //思路：我的第一解法 将所有的积乘完，然后遍历除以当前，此方案为考虑0的方案；思路二分别求出当前元素左侧乘积，和右侧乘积将两个元素相乘即可；时间复杂度O(n),空间复杂度多了储存前面元素的数组为O(n)
        if(nums == null || nums.length == 0) return new int[0];
        int[] left = new int[nums.length];
        int[] res = new int[nums.length];
        left[0] = 1;
        for(int i = 1; i < nums.length; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }
        int rightMultipty = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] = left[i] * rightMultipty;
            rightMultipty *= nums[i];
        }
        return res;
    }
}
