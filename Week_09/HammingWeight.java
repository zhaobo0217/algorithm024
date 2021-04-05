public class HammingWeight{

    public int hammingWeight(int n){
        // n &= (n - 1) 可以消除最后一个1的元素；只需要操作二进制中含1的个数次
        int count = 0;
        while(n != 0){
            n &= (n - 1);
            count++;
        }
        return count;
    }

    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        // n & 1 可以判断末尾元素是不是1，需要移动32次
        int count = 0;
       for(int i = 0; i < 32; i++){
           if(( n & 1) == 1) count++;
           n >>= 1;
        }
        return count;
    }
}
