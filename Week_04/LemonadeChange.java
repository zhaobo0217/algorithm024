public class LemonadeChange{

    public boolean lemonadeChange(int[] bills) {
        //题目分析：只需要记录5、10的数目，在金额为10的时候减去5，在金额20的时候优先使用10
        //时间复杂度O(n),空间复杂度O(1)
        if (bills == null) return false;
        int count5 = 0,count10 = 0;
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            //此处可以对钱进行校验，题目限定每单金额，可以跳过
            if (bill == 5){
                count5++;
            } else if (bill == 10){
                count5--;
                count10++;
            } else if(count10 > 0){
                count10--;
                count5--;
            }else {
                count5 -= 3;
            }
            if(count5 < 0) return false;
        }
        return true;
    }
}
