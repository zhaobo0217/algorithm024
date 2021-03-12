public class RobII{

    public int rob(int[] nums) {
        //首先可以想到使用动态规划，我们需要找到子问题解，如果只有一间房子，那么f(1) = room1;如果有两间屋子，f(2) = max(room1, room2),三间屋子f(3) = max(f(2),room3 + f(3 - 2))...可以递推出f(x) = max(f(x - 2) + r[k], f(x - 1));这样的递推公式；我也是比较顺利的完成了此步；但是这题的难点是收尾的房子也是连接在一起的，做了很多次尝试排掉此情况，一直卡在此处，从题解看到可以进行两次，十分精妙；时间复杂度为O(n),空间复杂度为O(n)记录动态规划，每次只与最近两次结果相关，可以优化为O(1)
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] nums, int l , int r){
        if(l >= r) return nums[l];
        int dp1 = nums[l];
        int dp2 = Math.max(nums[l], nums[l + 1]);
        for(int i = l + 2; i <= r; i++){
            int temp = dp2;
            dp2 = Math.max(nums[i] + dp1, dp2);
            dp1 = temp;
        }
        return dp2;
    }
}
