public class MySqrt{

     public int mySqrt(int x){
        if(x < 2) return x;
        long s = x >> 1;
        while(s * s > x){
            s = (s + x / s) / 2;
        }
        return (int)s;
    }

    public int mySqrt1(int x) {
        //这道题单调递增；有上下界[0,x]；可以使用二分查找的方法，时间复杂度为o(logn),空间复杂度为O(1)
        if(x == 0) return 0;
        long l = 1, r = x >> 1;
        long res = 1;
        while (l <= r){
            long mid = (r + l) >> 1;
            long square = mid * mid;
            if(square > x){
                r = mid - 1;
            }else{
                l = mid + 1;
                res = mid;
            }
        }
        return (int)res;
    }
}
