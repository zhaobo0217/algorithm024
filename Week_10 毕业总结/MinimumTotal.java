public class MinimumTotal{

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < m; i++){
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for(int j = i - 1; j > 0; j--){
                dp[j] = Math.min(dp[j], dp[j - 1] ) + triangle.get(i).get(j);
            }
            dp[0] = dp[0] + triangle.get(i).get(0);
        }
        int res = dp[0];
        for(int i = 1; i < n; i++) res = Math.min(res, dp[i]);
        return res;
    }
}
