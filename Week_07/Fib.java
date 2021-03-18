public class Fib{

     public int fib(int n) {
        if(n < 2) return n;
        int f0 = 0, f1 = 1;
        for(int i = 2; i <= n; i++){
            int temp = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = temp;
        }
        return f1;
    }
}
