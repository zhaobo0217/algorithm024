public class FindAnagrams {

  public List<Integer> findAnagrams(String s, String p) {
        //思路第一需要存储p中的字符，这样在下次判断的时候不用N^2的时间复杂度，通用是HashMap,纯字符可以选择char[26]
        //移动窗口，将之前窗口移出，新加，判断是否相同；时间复杂度O(n),空间复杂度O(1)
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length());
        int[] pRecord = new int[26];
        int[] sRecord = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ++pRecord[p.charAt(i) - 'a'];
        }
        int m = s.length();
        int n = p.length();
        for (int i = 0; i < m; i++) {
            ++sRecord[s.charAt(i) - 'a'];
            if (i >= n) --sRecord[s.charAt(i - n) - 'a'];
            if (i >= n - 1 && Arrays.equals(pRecord, sRecord)){
                res.add(i - n + 1);
            }
        }
        return res;
    }
}
