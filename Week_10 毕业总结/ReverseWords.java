public class ReverseWords{

    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        //思路：反方向寻找单词，然后将单词填入数组，每个单词之间填入空格字符即可；困难点，如何寻找单词，寻找前去除空格字符，知道下一个空格字符出现 即为一个单词（此题忽略标点，不然可以加上标点）；易错点：防止最后一个单词也添加空格，可以在添加单词时添加空格；时间复杂度O(n),空间复杂度O(n)
        char[] res = new char[s.length()];
        int index = 0;
        int r = s.length() - 1;
        while(r >= 0){
            if(s.charAt(r) == ' '){
                r--;
                continue;
            }
            //找单词，知道遇到第一个空格得到单词的长度
            int len = 0;
            while(r >= 0 && s.charAt(r) != ' '){
                len++;
                r--;
            }
            if(index > 0 && len > 0){
                //不是第一个或者最后一个单词的时候先加入空格
                res[index++] = ' ';
            }
            //从当前个位置拷贝len到新的结果
            int start = r + 1;
            while(len > 0){
                res[index++] = s.charAt(start++);
                len--;
            }
        }
        return String.valueOf(Arrays.copyOfRange(res, 0, index));
    }
}
