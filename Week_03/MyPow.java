public class MyPow {

    public double myPow(double x, int n){
	//时间复杂度O(logn),空间复杂度O(logn)
	if (n == 0) return 1;
	if (n == 1) return x;
	if (n == -1) return 1 / x;
	double half = myPow(x, n / 2);
	return n % 2 == 0 ? half * half : half * half * (n < 0 ? 1 / x : x);
    }

}
