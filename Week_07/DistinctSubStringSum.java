public class DistinctSubStringSum {


    public int numDistinct(String s, String t) {
        //这种判断子序列的都可以使用动态dp。建议一个二维表格，根据提议寻找最小子问题公式即可，类似问题还有二维数组中寻找子序列；时间复杂度O(m * n),空间复杂度为O(m * n),将观察dp只与前一列有关，可以简化到O(n);
       if(s == null || t == null || s.length() < t.length()) return 0;
       int m = s.length();
       int n = t.length();
       //这里一定要看清楚你dp的行列是什么 
       int[][] dp = new int[n + 1][m + 1];
       //我们可以想象子序列的第一个字符都为‘’，那么‘’是所有字符的子序列，将第一行付为1，这样做可以使我们在dp的时候可以不需要边界判断；
       for(int i = 0; i <= m; i++){
           dp[0][i] = 1;
       }
       //注意，行列对应关系
       for(int i = 0; i < m; i++){
           char sc = s.charAt(i);
           for(int j = 0; j < n; j++){
            //这里是dp的关键，其实我们将两个字符串拆分为最小单元，当前坐标包含的子序列数，跟它上一个最小子序列有关，也就是dp[j + 1][i],如果当前字符相同，那么他们两个分别的子序列即dp[j][i]所有的子序列也都变成包含子序列，需要加上dp[i][j];画一个二维表格更能说明问题
                if(t.charAt(j) == sc) dp[j + 1][i + 1] = dp[j + 1][i] + dp[j][i];
               else dp[j + 1][i + 1] = dp[j + 1][i];
           }
       }
       return dp[n][m];
    }
}
