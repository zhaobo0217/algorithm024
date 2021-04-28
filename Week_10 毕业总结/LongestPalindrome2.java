public class LongestPalindrome2 {
  public String longestPalindrome(String s) {
        //思路 每次向前走一步或者两步，主要防止奇数偶数的情况，找出最长的len;依次找出最大值
        if (s == null || s.length() < 2) return s;
        int len = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = palindromeLength(s, i, i);
            int len2 = palindromeLength(s, i, i + 1);
            if (Math.max(len1, len2) > len) {
                len  = Math.max(len1, len2);
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
            //剪枝
            if (end == s.length() - 1) break;
        }
        return s.substring(start, end + 1);
    }

    private int palindromeLength(String s, int l ,int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
