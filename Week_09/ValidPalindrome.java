public class ValidPdlindrome{

    //思路同验证回型字符串1，双指针；区别在于可以删除一个字符，当我们遇到不同的字符的时候，可以判断l + 1 到 r;和l 到 r - 1的区间是不是回文字符；最差为2n,时间复杂度为O(n),空间复杂度为O(1)
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l , r - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int l , int r){
        int start = l , end = r;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
