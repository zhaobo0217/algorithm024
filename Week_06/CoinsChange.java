public class CoinsChange{
    //两种做法动态规划 和递归；加上剪枝和贪心的递归，效果优于dp
    int res = Integer.MAX_VALUE; 
    public int coinChange(int[] coins, int amount){
        //递归方法可以找一个小的值画出递归树，更能方便的剪枝
        if(coins == null || amount < 0) return -1;
        Arrays.sort(coins);
        recursion(coins, amount, 0, coins.length - 1);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private void recursion(int[] coins, int amount, int count, int index){
        if(amount == 0) res = Math.min(count, res);
        if(amount < 0 || index < 0) return;
        //这个地方常规的根据前一张一张减的话会超过时间限度，这里采用贪心，先减去最多的，一步一步回退，当前步骤已经超过了之前的步骤的话，剪枝
        for(int i = amount / coins[index]; i >= 0 && count + i < res; i--){
            recursion(coins, amount - (coins[index] * i), count + i, index - 1);
        }
    }

    public int coinChange1(int[] coins, int amount){
       //可以看出最后的零钱数，可以从上一阶段的零钱数，与可兑换的零钱得到，因此可以使用动态规划求解；找出最小重复子问题,dp方程为f(x) = min(f(x - k) k  in coins) + 1;其实就是上一个换成的中找到一个最少的 + 1；时间复杂度为O(n)，空间复杂度用到dp也为O(n);
        if(coins == null || amount < 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
