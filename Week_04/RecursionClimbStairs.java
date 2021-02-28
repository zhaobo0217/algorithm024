public class RecursionClimbUpstairs{

    //递归方式解决爬楼梯问题
    public int climbStairs(int n) {
        //递归的写法：递归的时间复杂度需要单独的分析最好为O(logn)，最坏可能为O(k^n),k为分叉树；当前算法为遍历到每个台阶，时间复杂度为O(n);递归的空间复杂度为层级深度，此处为O(n);
        return climb(1, 1, n);
    }

    private int climb(int n1, int n2, int n){
        if(n <= 1){
            //terminator
            return n2;
        }
        // process && drill down
        return climb(n2, n1 + n2, n - 1);
    }
}
