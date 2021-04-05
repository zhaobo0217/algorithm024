public class IsPalindrome{

    public boolean isPalindrome(String s) {
        //双指针法时间复杂度为O(n)，空间复杂度O(1)
        if(s == null || s.length() == 0) return false;
        int l = 0, r = s.length() - 1;
        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if(l < r && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            } 
            l++;
            r--;
        }
        return true;
    }
}
