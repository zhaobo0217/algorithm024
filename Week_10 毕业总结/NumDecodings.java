public class NumDecodings{

    public int numDecodings(String s) {
        //解题思路：动态规划，比较容易可以得出如果当前二位的时候满足区间dp[i] = dp[i - 1] + dp[i - 2];否则 dp[i] = dp[i - 1];这道题比较难的地方是带0；导致我出错好几次，如果此时构成的值是10或者20，那么dp[i] = dp[i - 2],如果是00，连续0，应该直接返回0；如果是30.40.50也不能满足条件不能构成字母，且0不能单独构成，此时也应该返回0；时间复杂度O(n),空间复杂度O(n)或O(1)可以优化
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1; i < n; i++){
            int curValue = (s.charAt(i - 1) - 48) * 10 + (s.charAt(i) - 48);
            if(curValue == 0) return 0;
            if(curValue == 10 || curValue == 20){
                dp[i + 1] = dp[i - 1];
            }else if(curValue > 10 && curValue <= 26){
                dp[i + 1] = dp[i] + dp[i - 1];
            }else if(s.charAt(i) == '0'){
                return 0;
            }else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[n];
    }
}
