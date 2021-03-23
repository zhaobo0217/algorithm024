public class IsPerfectSquare{

     public boolean isPerfectSquare(int num) {
        //符合单调性和终止条件，可以使用二分法；时间复杂度为O(logN),空间复杂度为O(1);
        if(num == 1) return true;
        long l = 2, r = num >> 1, mid = 0, midSquare = 0;
        while(l <= r){
            mid = (l + r) >> 1;
            midSquare = mid * mid;
            if(midSquare == num) return true;
            if(midSquare > num) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
