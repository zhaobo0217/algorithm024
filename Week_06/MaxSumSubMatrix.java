public class MaxSumSubMatrix{

    public int maxSumSubmatrix(int[][] matrix, int k) {
        //这道题需要画图更容易理解，我们需要一列数组dp[]为数组记录每一行的连续sum，然后比较这一列中的连续子序列的和不大于k的值和结果取max;时间复杂度o(m^2*n)~o(m^2*n^2),空间复杂度O(n)
        if(matrix == null || matrix.length == 0) return Integer.MIN_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = Integer.MIN_VALUE;
        int[] dp = new int[rows];
        for(int i = 0; i < cols; i++){
            Arrays.fill(dp, 0);
            for(int j = i; j < cols; j++){
                for(int l = 0; l < rows; l++){
                    dp[l] += matrix[l][j];
                }
                res = Math.max(res, maxSubSumK(dp, k));
                if(res == k) return res;
            }
        }
        return res;
    }

    private int maxSubSumK(int[] arr, int k){
        int rollSum = arr[0], rollMax = rollSum;
        for (int i = 1; i < arr.length; i++) {
            rollSum = Math.max(rollSum + arr[i], arr[i]);
            rollMax = Math.max(rollSum, rollMax);
            if(rollMax == k) return rollMax;
        }
        if (rollMax <= k) return rollMax;
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) max = sum;
                if (max == k) return k;
            }
        }
        return max;
    }
}
