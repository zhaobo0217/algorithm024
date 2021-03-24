public class RobI{

    public int rob(int[] nums) {
        //当前家f(x) = max(f(x - 1), f(x - 2) + x),时间复杂度为O(n),空间复杂度为O(1)
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int d0 = 0, d1 = nums[0], res = d1;
        for(int i = 1; i < nums.length; i++){
            res = Math.max(d1, d0 + nums[i]);
            d0 = d1;
            d1 = res;
        }
        return res;
    }

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[len];
    }
}
