public class Atoi {

  public int myAtoi(String s) {
      //这道题思路比较简单，关键点1、可以通过0 <= s.charAt(i) - '0' <= 9 可以判断字符是不是数字；关键点2，(int_max - num) / 10 < total ;说明加上当前数组就会超出int的界限，直接break编辑即可；时间复杂度度O(n)，空间复杂度O(1)
      if(s == null || s.length() == 0) return 0;
      int res = 0;
      int index = 0;
      int flag = 1;
      while (index < s.length() && s.charAt(index) == ' '){
          index++;
      }
      if (index >= s.length()) return 0;
      if(s.charAt(index) == '+' || s.charAt(index) == '-') {
          if (s.charAt(index) == '-') flag = -1;
          index++;
      }
      while (index < s.length()) {
          int num = s.charAt(index++) - '0';
          if (num < 0 || num > 9) break;
          if ((Integer.MAX_VALUE - num) / 10 < res){
              return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
          }
          res  = res * 10 + num;
      }
      return res * flag;
  }
}
