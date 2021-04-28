public class IsIsomorphic2 {

  public boolean isIsomorphic(String s, String t) {
      //这道提需要注意一个字符不能有多个影射，因此需要记录下T的字符，如果t已经在之前的影射中出现过了，那么直接返回错误；时间复杂度O(n),空间复杂度O(n)
      if (s == null || t ==null || s.length() != t.length()) return false;
      Map<Character, Character> recordMap = new HashMap<>();
      Set<Character> tRecordSet = new HashSet<>();
      for (int i = 0; i < s.length(); i++) {
          char sC = s.charAt(i);
          char sT = t.charAt(i);
          if (!recordMap.containsKey(sC)) {
              if(tRecordSet.contains(sT)) return false;
              recordMap.put(sC, sT);
              tRecordSet.add(sT);
          }else if (recordMap.get(sC) != sT) {
              return false;
          }
      }
      return true;
  }
}
