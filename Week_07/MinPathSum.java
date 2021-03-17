public class MinPathSum{

    public int minPathSum(int[][] grid) {
        //动态规划；选择上面和左面较小的那个加上当前值，取最后值；时间复杂度O(m*n);空间复杂度O(m*n);
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 || j == 1) dp[i][j] = dp[i][j - 1] + dp[i - 1][j] + grid[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j])+ grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
