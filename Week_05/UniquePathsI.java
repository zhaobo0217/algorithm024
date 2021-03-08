public class UniquePathsI{
    //此题可用动态规划求解，起始位置的边界设置为1，其余位置的路径数应为当前位置上面一个值和左面值的和，时间复杂度为O(m * n) 空间复杂度为O(mn)
    public int uniquePaths(int m, int n){
	if (m <= 0 || n <= 0) return 0;
	int[][] dp = new int[m + 1][n + 1];
	for (int i = 1; i <= m; i++){
	    for (int j = 0; j <= n; j++) {
		if(dp[i - 1][j] == 0 || dp[i][j - 1] == 0) dp[i][j] = 1;
		else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
	    }
	
	}
	rerurn dp[m][n];
    }
}
