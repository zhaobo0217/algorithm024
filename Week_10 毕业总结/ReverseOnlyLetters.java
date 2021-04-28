public class ReverseOnlyLetters{

  public String reverseOnlyLetters(String S) {
      //双指针，时间复杂度O(n),空间复杂度O(1);
      if (S == null || S.length() == 0) return S;
      char[] charArray = S.toCharArray();
      int start = 0;
      int end = S.length() - 1;
      while (start < end) {
          if (!Character.isLetter(charArray[start])) {
              start++;
              continue;
          }
          if (!Character.isLetter(charArray[end])) {
              end--;
              continue;
          }
          char temp  = charArray[start];
          charArray[start++] = charArray[end];
          charArray[end--] = temp;
      }
      return String.valueOf(charArray);
  }
}
