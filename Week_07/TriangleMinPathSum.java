public class TriangleMinPathSum{

    public int minimumTotal(List<List<Integer>> triangle){
        int res = 0;
        if(triangle == null || triangle.isEmpty()) return res;
        //方法二：从方法一可以看出，我们的dp[][]有很大的冗余空间，可以优化，可以得出当前行只与上一行得出的值相关；我自己推出这个结论，没有实现；看到题解第二维倒着递归，解决了我的卡点；
        int len = triangle.size();
        int[] dp = new int[len];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < len; i++){
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for(int j = i - 1; j > 0; j--){
                dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
            }
            dp[0] = dp[0] + triangle.get(i).get(0);
        }
        res = dp[0];
        for(int i = 1; i < len; i++) res = Math.min(res, dp[i]);
        return res;
    }
}
