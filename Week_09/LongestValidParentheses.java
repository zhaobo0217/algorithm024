public class LongestValidParentheses{

    public int longestValidParentheses(String s) {
        //动态规划，当s[i] = ")"有两种情况：1.s[i - 1] = '(' 标识当前元素跟上一个元素构成了有效括号，dp[i] = dp[i - 2] + 2;情况2、s[i - 1] = ')'且 s[i - dp[i - 1] -1] == '(' ;dp[i] = dp[i - 1] + 2 + dp[i - 2 - dp[i - 1]] ;时间复杂度O(n),空间复杂度O(n)
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public int longestValidParentheses1(String s) {
        //利用栈，时间复杂度O(n),空阿金复杂度最差为O(n)
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        Stack<Integer> record = new Stack<>();
        record.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                record.push(i);
            }else{
                record.pop();
                if(record.isEmpty()){
                    record.push(i);
                }else{
                    res = Math.max(res, i - record.peek());
                }
            }
        }
        return res;
    }
}
