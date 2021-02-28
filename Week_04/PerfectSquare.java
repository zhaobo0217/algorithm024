public class PerfectSquare {

     public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        //时间复杂度O(logN),空间复杂度O(1)
        long l = 2, r = num / 2, p  = 0;
        long temp = 0;
        while (l <= r) {
            p = (l + r) / 2;
            temp = p * p;
            if (temp == num) return true;
            else if(temp > num) r = p - 1;
            else l = p + 1;
        }
        return false;
    }
}
