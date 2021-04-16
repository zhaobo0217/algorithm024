public class LetterCombinations{

    public List<String> letterCombinations(String digits) {
        //回溯，时间复杂度o（3^m * 4^n），空间复杂度O(n)
         List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        List<String> digitList = new ArrayList<>();
        for(int i = 0; i < digits.length(); i++){
            char c = digits.charAt(i);
            if(c == '2') digitList.add("abc");
            else if(c == '3') digitList.add("def");
            else if(c == '4') digitList.add("ghi");
            else if(c == '5') digitList.add("jkl");
            else if(c == '6') digitList.add("mno");
            else if(c == '7') digitList.add("pqrs");
            else if(c == '8') digitList.add("tuv");
            else if(c == '9') digitList.add("wxyz");
        }
        letterCombinations(res, digitList, 0, new char[digits.length()]);
        return res;
    }

    private void letterCombinations(List<String> res, List<String> digitList, int level, char[] s){
        if(level == digitList.size()){
            res.add(String.valueOf(s));
            return;
        }
        char[] charArray = digitList.get(level).toCharArray();
        for(int i = 0; i < charArray.length; i++){
            s[level] = charArray[i];
            letterCombinations(res, digitList, level + 1, s);
        }
    }
}
