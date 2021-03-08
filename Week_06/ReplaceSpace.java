public class ReplaceSpace{

    public String replaceSpace(String s) {
        //这道题关键在于如何确定字符数组的长度；可以使用先遍历找出空格，也可以直接s.length * 3
        if(s == null) return s;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }
}
