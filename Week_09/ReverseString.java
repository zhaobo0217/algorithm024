public class ReverseString{

    public String reverseStr(String s, int k){
        if(s == null || k < 1) return s;
        //思路：遇到2k的起始点开始，双指针交换起始点i到i + k -1之间数，然后指针跳到2k位置处；时间复杂度为O(k / 2) = O（n）空间复杂度为O(1);
        char[] charArray = s.toCharArray();
        int k2 = k * 2;
        int i = 0;
        while(i < charArray.length && i % k2 == 0){
            int l = i ;
            int r = Math.min(i + k - 1, charArray.length - 1);
            while(l < r){
                char temp = charArray[l];
                charArray[l++] = charArray[r];
                charArray[r--] = temp;
            }
            i += k2;
        }
        return String.valueOf(charArray);
    }

    public String reverseStr1(String s, int k) {
        if(s == null || k < 1) return s;
        //方法2：使用栈结构；时间复杂度（3k/2） = O(n),空间复杂度O(n)
        StringBuilder  sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int pos = 0;
        int k2 = k * 2;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(pos < k){
                stack.push(c);
                if(pos == k - 1 || i == s.length() - 1){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                }
            }else{
                sb.append(c);
            }
            if(pos == k2 - 1) pos = 0;
            else pos++;
        }
        return sb.toString();
    }
}
