public class NumDistinct{

  public int numDistinct(String s, String t) {
        //子序列问题。采用动态规划，使用二维表格，递推出动态规划方程
        //如果当前字符相同，dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];dp[i - 1][j - 1]代表两个串都没有添加新字符的情况下s子序列在t中出现的个数，dp[i][j - 1]表示新添加字符已经匹配的个数，两个相加即为当前位置的匹配个数。如果当前字符不同，等于上一个字符匹配即可
        //时间复杂度O(mn)空间复杂度O(mn)
        if(s == null || t == null) return 0;
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i <= m; i++){
          //这句话抽取出来可以节省不少时间
            char tc = t.charAt(i - 1);
            for(int j = 1; j <= n; j++){
                if(tc == s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
