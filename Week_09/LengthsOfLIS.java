public class LengthsOfLIS{

    public int lengthOfLIS(int[] nums){
        //方案2：贪心+二分法，新建一个数组存放已排序的元素。如果当前元素大于数组最后的元素，将当前元素添加到数组内，否则替换新数组对应元素，保证数组的长度的同时，每个位置的元素都是相对最小的，这样数组才能放入更多的元素，这也是这道题贪心的核心；时间复杂度O(nlogn),空间复杂度O(n)
        if(nums == null || nums.length == 0) return 0;
        int[] d = new int[nums.length];
        d[0] = nums[0];
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > d[index]){
                d[++index] = nums[i];
            }else{
                int l = 0, r = index, pos = 0;
                while(l <= r){
                    int mid = (r + l) >> 1;
                    if(nums[i] <= d[mid]){
                        pos = mid;
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }
                d[pos] = nums[i];
            }
        }
        return index + 1;
    }

    public int lengthOfLIS1(int[] nums) {
        //方案一：动态规划；需要两级的循环，核心在于第二级，将之前的值小于这个值位置都+1，最终拿出dp中最大的值；时间复杂度O(n^2),空间复杂度O(n)
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = dp[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
