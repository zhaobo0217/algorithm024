public class ReverseBits{

    public int reverseBits(int n) {
        //增加n!=0的判断
        int res = 0;
        for(int i = 0; i < 32 && n != 0; i++){
            res |= (n & 1) << (31 - i);
            n >>= 1;
        }
        return res;
    }
}
