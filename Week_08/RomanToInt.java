public class RomanToInt{

    public int romanToInt(String s) {
        //时间复杂度O(n),空间复杂度O（1）
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> record = new HashMap<>();
        record.put('I', 1);
        record.put('V', 5);
        record.put('X', 10);
        record.put('L', 50);
        record.put('C', 100);
        record.put('D', 500);
        record.put('M', 1000);
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            int value = record.get(s.charAt(i));
            int postValue = i < s.length() - 1 ? record.get(s.charAt(i + 1)) : 0;
            if(value < postValue) res -= value;
            else res += value;
        }
        return res;
    }   
}
