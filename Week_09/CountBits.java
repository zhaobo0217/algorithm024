public class CountBits{

    public int[] countBits(int num) {
        //思路：x * 2 = x << 1即 x 右移动一位，可以count(2x) == count(x >> 1);此时的2x只能是偶数，基数方案count（2x + 1）= count(x >> 1) + 1;相邻的奇数位一定比上一个偶数为多1，因此可以得到递推方程f(x) = f(x/2)+ isEven ? 1 : 0;时间复杂度为O(n),空间复杂度O(1)
        int[] res = new int[num + 1];
        for(int i = 1; i <= num; i++){
            res[i] = res[i >> 1] + (i & 1);
        } 
        return res;
    }
}
