public class ClimbStairs{

    public int climbStairs(int n) {
        //动态规划，一级楼梯只有一种走法，二级楼梯可以走一级也可以一步走两级；第三级我们可以递推出为一级 + 二级个数，使用动态规划存储相邻两部的状态即可；时间复杂度O(n)
        if(n < 3) return n;
        int f1 = 1;
        int f2 = 2;
        for(int i = 3; i <= n; i++){
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}
