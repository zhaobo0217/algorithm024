public class LongestPalindromeDp{

    //动态规划;这道题的题解看了好久，主要是学一下动态规划的解法；卡点主要是这里二维数组存储的实际是子序列的两个边界值，与之前dp不同，思维一下无法转化；基本思想也是每次只需要判断外层是否相同，相同的话临近内层如果是回文串那么也是，否则不是；我们一样需要枚举子串长度2.....n，时间复杂度依然是O(n^2),空间复杂度O(n^2)
        if(s == null || s.length() < 2) return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        //每个单独的字符都是回文字符
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        int end = 0;
        for(int l = 2; l <= len; l++){
            for(int i = 0; i < len; i++){
                //枚举的新元素的边界，只需要判断两个边界是否相同，之前已经dp过了
                int j = l + i - 1;
                if(j >= len) break;
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    if(l == 2) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                }
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
