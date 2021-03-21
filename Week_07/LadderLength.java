public class LadderLength{

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //这道题的第一思路应该是采用bfs，将beginword 加入到队列当中，一层一层寻找差一个字母的，直到最后结束；难点为如何查找出字母与当前只差一个的字符串；此方法在分叉越来越多的时候，效率将大幅下降；其实和目标都为1，可以使用双向bfs，时间复杂度为O（36 * k * n）即为O(n);空间复杂度为O(n);
        if(beginWord == null || endWord == null || wordList == null || wordList.isEmpty()) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        wordSet.remove(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        //记录访问过的集合
        Set<String> visited = new HashSet<>();
        //层级记录
        Set<String> levelSet = new HashSet<>();

        int len = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            levelSet.clear();
            for(String word : beginSet){
                char[] letters = word.toCharArray();
                for(int i = 0; i < letters.length; i++){
                    char tempC = letters[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        letters[i] = c;
                        String nString = String.valueOf(letters);
                        if(!wordSet.contains(nString)) continue;
                        if(endSet.contains(nString)) return ++len;
                        if(!visited.contains(nString)){
                            visited.add(nString);
                            levelSet.add(nString);
                        }
                    }
                    letters[i] = tempC;
                }
            }
            ++len;
            beginSet.clear();
            beginSet.addAll(levelSet);
        }
        return 0;
    }
}
