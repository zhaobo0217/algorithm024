// 通配符匹配
public class IsMatch{

  public boolean isMatch(String s, String p) {
      //动态规划，需要先找到递推方程，如果不考虑*的情况dp[i][j] = dp[i - 1][j - 1]
      //&& isMatch(char[i], char[j]),即如果当前两个字符串的字符相同的的话，
      //如果他们之前的字符是相同的他们才是匹配的；这一层比较容易；如果加上*匹配0+，
      //dp[i - 1][j - 1]代表新字符之前的串完全是匹配的，*的将不完全，
      //* 可以一直向后匹配因此这里的递推方程为dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
      //到这里我们还遗漏了p起始位置是*的情况，我们需要将这个边界设置成true;这类问题需要花一个二维表格更容易理解；
      //时间复杂度O(mn),空间复杂度为O(mn),可降至O(m)
      if(s == null || p == null) return false;
      int m = s.length();
      int n = p.length();
      boolean[][] dp = new boolean[m + 1][n + 1];
      for(int i = 0; i <= n; i++){
          if(i == 0 || p.charAt(i - 1) == '*') dp[0][i] = true;
          else break;
      }
      for(int i = 1; i <= m; i++){
          for(int j = 1; j <= n; j++){
              if(p.charAt(j - 1) == '*'){
                  dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
              }else if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?'){
                  dp[i][j] = dp[i - 1][j - 1];
              }
          }
      }
      return dp[m][n];
  }
}
