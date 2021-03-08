public class LadderLength{

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //双向广度优先遍历BFS，方式数或者图层级指数增长，两侧以菱形方式，减少多余计算；
        //第一步：构建图，常见方式为双层遍历wordList找出只有一个字符不同的节点，时间复杂度为n*n*字符长度O(k*n^2),题解通过替换字符形式时间复杂度为O(26*n)只要K*n>26题解更优；然后双向BFS，最差需要遍历到每个节点时间复杂度，总时间复杂度为O(26*n*n)为O(n^2);空间复杂度为O(5n)为O(n)
        if(beginWord == null || endWord == null || wordList == null) return 0;
        Set<String> words = new HashSet<>(wordList);
        if(words.size() == 0 || !words.contains(endWord)){
            return 0;
        }
        words.remove(beginWord);
        Set<String> visited =new HashSet<>();
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        visited.add(beginWord);
        visited.add(endWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);
        Set<String> levelVisited = new HashSet<>();
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()){
            if(beginVisited.size() > endVisited.size()){
                Set<String> tempVisited = beginVisited;
                beginVisited = endVisited;
                endVisited = tempVisited;
            }
            levelVisited.clear();
            for (String word : beginVisited){
                char[] charArray = word.toCharArray();
                for(int i = 0; i < charArray.length; i++){
                    char tempC = charArray[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        charArray[i] = c;
                        String newString = String.valueOf(charArray);
                        if(words.contains(newString)){
                            if(endVisited.contains(newString)){
                                return step + 1;
                            }
                            if(!visited.contains(newString)){
                                visited.add(newString);
                                levelVisited.add(newString);
                            }
                        }
                    }
                    charArray[i] = tempC;
                }
            }
            beginVisited.clear();
            beginVisited.addAll(levelVisited);
            step++;
        }
        return 0;
     }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        //使用广度遍历BFS
        if(beginWord == null || endWord == null || wordList == null) return 0;
        Set<String> words = new HashSet<>(wordList);
        if(words.size() == 0 || !wordList.contains(endWord)) return 0;
        words.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int count = 0; count < size; count++){
                String word = queue.poll();
                char[] charArray = word.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char cTemp = charArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if(cTemp == c){
                            continue;
                        }
                        charArray[i] = c;
                        String newString = String.valueOf(charArray);
                        if(words.contains(newString)){
                            if(newString.equals(endWord)){
                                return step + 1;
                            } 
                            if (!visited.contains(newString)) {
                                visited.add(newString);
                                queue.offer(newString);
                            }
                        }
                    }
                    charArray[i] = cTemp;
                }
            }
            step++;
        }
        return 0;
    }
}
