public class ShipWithinDays {

    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length() == 0 || D < 1) return 0;
        //使用二分法 先找出weights 中最大的值，作为左边界，然后所有值的和作为右边界，然后使用二分逐个尝试；时间复杂度为O(n* log(m - n))时间复杂度为O(1);
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            int cur = 0;
            int days = 1;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++days;
                    cur = 0;
                }
                cur += weight;
            }
            //通常的二分法找到结束，此处第一次找到可能并不是最小的值，需要移动右边界再试一次
            if (days <= D) {
                //同上述注释，此处不能再使用mid - 1; 防止漏掉正确的答案
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //此处直接返回left即可
        return left;
    }
}
