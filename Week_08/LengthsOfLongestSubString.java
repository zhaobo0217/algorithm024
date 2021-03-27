public class LengthsOfLongestSubString{

    public int lengthOfLongestSubstring(String s) {
        //思路：使用一个map记录字母的位置，使用left记录上一个边界，当发现相同元素的时候，更新边界，此处一定要切记，边界回走的问题，此处应该max(left, 上一个元素位置)i - left + 1即上一个阶段不重复的最大长度，时间复杂度O(n),空间复杂度至多O(n)
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> record = new HashMap<>();
        int res = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(record.containsKey(c)){
                //left不能往回走，abba
                left = Math.max(record.get(c) + 1, left);
            }
            record.put(c, i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
