public class DigitsAdd {
   
    public int addDigits1(int num) {
        //来自题解，数字规律，数字根是1到9一直循环的，非9倍数为(n mod 9),9倍数为9;(n - 1) mod 9 +1省去了分开判断；
        return (num - 1) % 9 + 1;
    }

    public int addDigits(int num) {
	if (num < 10) return num;
	int value = 0;
	int cNum = num;
	while (cNum > 0) {
	    int digit = cNum % 10;
	    value += digit;
	    cNum /= 10;
	}
	return addDigits(value);
    }
}
