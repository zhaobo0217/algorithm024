public class IsMatch2 {
  public boolean isMatch(String s, String p) {
        //贪心
        if (s == null || p == null) return false;
        int sEndIndex = s.length() - 1;
        int pEndIndex = p.length() - 1;
        while(sEndIndex >= 0 && pEndIndex >= 0 && p.charAt(pEndIndex) != '*'){
            if(p.charAt(pEndIndex) == '?' || p.charAt(pEndIndex) == s.charAt(sEndIndex)){
                sEndIndex--;
                pEndIndex--;
            }else{
                return false;
            }
        }
        if(pEndIndex < 0) return sEndIndex < 0;
        int sRecordIndex = -1, pRecordIndex = -1;
        int sIndex= 0, pIndex= 0;
        while(sIndex <= sEndIndex && pIndex <= pEndIndex) {
            char c = p.charAt(pIndex);
            if(c == '*') {
                pIndex++;
                sRecordIndex = sIndex;
                pRecordIndex = pIndex;
            }else if(c == '?' || c == s.charAt(sIndex)) {
                pIndex++;
                sIndex++;
            }else if(pRecordIndex > -1 && sRecordIndex < sEndIndex) {
                sRecordIndex++;
                //这个位置依旧忘记将s的索引也移动到之前的位置上
                pIndex = pRecordIndex;
                sIndex = sRecordIndex;
            }else {
                return false;
            }
        }
        return isAllStar(p, pIndex, pEndIndex);
    }

    private boolean isAllStar(String p, int s, int e){
        while(s <= e){
            if(p.charAt(s++) != '*'){
                return false;
            }
        }
        return true;
    }

    public boolean isMatch1(String s, String p) {
        //动态规划 和贪心
        if(s == null || p == null) return false;
        int m = p.length();
        int n = s.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0]  = true;
        for(int i = 1; i <= m && p.charAt(i - 1) == '*'; i++ ){
            dp[i][0] = true;
        }
        for(int i = 1; i <= m; i++){
            char c = p.charAt(i - 1);
            for(int j = 1; j <= n; j++){
                if(c == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else if(c == '?' || c == s.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
