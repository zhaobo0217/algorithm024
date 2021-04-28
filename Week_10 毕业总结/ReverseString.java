public class ReverseString {

  public String reverseStr(String s, int k) {
      //时间复杂度O(n)，空间复杂度O(n),基本思路是贪心，只要是起始位置就向后换，然后将当前的索引向后跳2k
      if (s == null || s.length() == 0 || k < 2) return s;
      int doubleK = k * 2;
      int index = 0;
      char[] charArray = s.toCharArray();
      while (index < charArray.length) {
          if (index % doubleK == 0) {
              reverse(charArray, index, index + k -1);
              index += doubleK;
          }else{
              break;
          }
      }
      return String.valueOf(charArray);
  }

  private void reverse(char[] charArray, int s, int e) {
      int start = s;
      int end = Math.min(charArray.length - 1, e);
      while (start < end) {
          char temp = charArray[start];
          charArray[start++] = charArray[end];
          charArray[end--] = temp;
      }
  }
}
