public class IsIsomorphic{

    //思路利用hashmap记录影射关系；时间复杂度O(n),空间复杂度O(n);误区一：并不是双向影射，需要两个hashmap,误区二：字符并不一定都是字母，不要使用char[26]
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        HashMap<Character,Character> record = new HashMap<>();
        HashMap<Character,Character> recordT = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sC = s.charAt(i);
            char tC = t.charAt(i);
            if((record.containsKey(sC) && record.get(sC) != tC) || (recordT.containsKey(tC) && recordT.get(tC) != sC)){
                return false;
            }
            record.put(sC, tC);
            recordT.put(tC, sC);
        }
        return true;
    }
}
