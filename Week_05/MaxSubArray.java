public class MaxSubArray{

    public int maxSubArray1(int[] nums){
        //DP,求f(x)的最大子序列和，可以看成求 f(x-1)的最大子序列和加上x的值和x的大小，只需要每次存储前一个值即可；时间复杂度O(n)，空间复杂度O(1)
        if(nums == null || nums.length == 0) return 0;
        //默认结果取第一个元素
        int res =nums[0];
        int sub = 0;
        for(int num : nums){
            //拿出之前一个子序列+当前值和当前值的最大值
            sub = Math.max(sub + num, num);
            res = Math.max(res, sub);
        }
        return res;
    }

    public int maxSubArray(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        //分治，分别得到左半边最大值，右边最大值，带mid的两边的最大值
        return maxSub(nums, 0, nums.length - 1);
    }

    private int maxSub(int[] nums, int l, int r){
        if(l >= r) return nums[l];
        int mid = (l + r) >> 1;
        int leftSum = maxSub(nums, l, mid);
        int midSum = accrossMidMax(nums, l, mid, r);
        int rightSum = maxSub(nums, mid + 1, r);
        return Math.max(midSum, Math.max(leftSum, rightSum));
    }

    private int accrossMidMax(int[] nums, int l, int mid, int r){
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i >= l; i--){
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for(int j = mid + 1;j <= r; j++){
            sum += nums[j];
            rightSum = Math.max(rightSum,sum);
        }
        return leftSum + rightSum;
    }
}
