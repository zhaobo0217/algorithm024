public class FindMaxSubArrayLength{

    public int findLength(int[] A, int[] B) {
	//此题与之前的移到寻找自字符串长度类似，动态规划，区别在于字符串不要求连续，此题连续，那么不同的值的时候应该赋值0，时间复杂度O(mn),空间复杂度为O(mn),由于只与上一层相关，可以简化为一层O(n);
        if(A == null || A.length == 0 || B == null || B.length == 0) return 0;
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(A[i] == B[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    res = Math.max(res, dp[i + 1][j + 1]);
                }
            }
        }
        return res;
    }

     public int findLength(int[] A, int[] B) {
        //滑动窗口，时间复杂度O((m + n)*min(m, n))，空间复杂度为O(1)
        int m = A.length;
        int n = B.length;
        int res = 0;
        for(int i = 0; i < m; i++){
            int len = Math.min(m - i, n);
            int max = maxLength(A, B, i, 0, len);
            res = Math.max(max, res);
        }
        for(int j = 0; j < n; j++){
            int len =  Math.min(n - j, m);
            int max = maxLength(A, B, 0, j, len);
            res = Math.max(max, res);
        }
        return res;
    }

    private int maxLength(int[] A, int[] B, int sA, int sB, int len){
        int sub = 0, max = 0;
        for(int i = 0; i < len; i++){
            if(A[sA + i] == B[sB + i]){
                sub++;
            }else{
                sub = 0;
            }
            max = Math.max(sub, max);
        }
        return max;
    }
}
