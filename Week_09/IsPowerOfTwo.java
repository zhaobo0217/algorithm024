public class IsPowerOfTwo{

    public boolean isPowerOfTwo(int n) {
        //2的幂次方肯定是大于0的，2的幂次方的二进制中只能含有一个元素，n & n - 1 可以消除低位第一个1
        return (n > 0) && (n & (n - 1)) == 0;
    }
}
