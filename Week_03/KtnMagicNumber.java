public class KthMagicNumber {

    public int getKthMagicNumber(int k) {
        if (k <= 0) return 0;
        //因子只能是3，5，7的数，只能由之前的某个数*3，*5，*7得到；时间复杂度为O(n),空间复杂度为O(n)
        int[] res = new int[k];
        res[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < k; i++) {
            int num3 = res[p3] * 3;
            int num5 = res[p5] * 5;
            int num7 = res[p7] * 7;
            res[i] = Math.min(num3, Math.min(num5, num7));
            if (res[i] == num3) p3++;
            if (res[i] == num5) p5++;
            if (res[i] == num7) p7++;
        }
        return res[k - 1];
    }
}
