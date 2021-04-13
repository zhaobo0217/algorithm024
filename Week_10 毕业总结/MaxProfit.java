public class MaxProfit{

    public int maxProfit(int[] prices) {
        //如果当前股票价格大于前一天交易即可；时间复杂度O(n),空间复杂度O(1)
        if(prices == null || prices.length == 0) return 0;
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]) sum += (prices[i] - prices[i - 1]);
        }
        return sum;
    }
}
