public class MaxProfit{

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        //直接遍历，时间复杂度O(n),空间复杂度O(1)
        int sum = 0;
        for (int  i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]){
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public int maxProfit(int[] prices){
        //递归，时间复杂度O(n),空间复杂度O(n)
        return profit(1, prices, 0);
    }

    private int profit(int level, int[] prices, int sum){
        //terminator
        if (level >= prices.length) return sum;
	    //process
            if(prices[level] > prices[level - 1]) sum += (prices[level] - prices[level - 1]);
	    //drill down
            return profit(level + 1, prices, sum);
        }
}
