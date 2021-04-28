public class ReverseWordsIII {

  public String reverseWords(String s) {
      if (s == null || s.length() == 0) return s;
      int start = -1;
      //时间复杂度O(n)，空间复杂度O(1),思路记录下字符串起始的坐标，找到end坐标后反转之前的字符即可
      char[] charArray = s.toCharArray();
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (c == ' ' && start != -1) {
              reverse(charArray, start, i - 1);
              start = -1;
          }else if (c != ' ' && start == -1) {
              start = i;
          }
      }
      if (start != -1) reverse(charArray, start, s.length() - 1);
      return String.valueOf(charArray);
  }

  private void reverse(char[] charArray, int s, int e){
      while (s < e) {
          char temp = charArray[s];
          charArray[s] = charArray[e];
          charArray[e] = temp;
          s++;
          e--;
      }
  }
}
