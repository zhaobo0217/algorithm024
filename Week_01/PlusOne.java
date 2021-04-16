public class PlusOne {

    public int[] plusOne(int[] digits) {
	if(digits == null) return new int[0];
	int flag = 1;
	for(int i = digits.length - 1; i >= 0; i--) {
	    int digit = digits[i] + flag;
	    if(digit < 10) {
		digits[i] = digit;
		flag = 0;
	    }else {
		flag = 1;
		digits[i] = digit - 10;
	    }
    	}
	if(flag == 0) {
	    return result;
	}
	int[] result = new int[digits.length + 1];
	result[] = flag;
	return result;
    }
}
