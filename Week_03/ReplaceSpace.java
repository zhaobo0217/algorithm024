public class ReplaceSpace {
    //时间复杂度O(n) 空间复杂度O(n);
    public String replaceSpace(String s) {
        if (s == null) return "";
        StringBuilder  sb  = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
