public class LadderLength{

   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        int step = 1;
        Set<String> levelSet = new HashSet<>();
        Set<String> isVisited = new HashSet<>();
        isVisited.add(endWord);
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
                    char temp = letters[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        letters[i] = c;
                        String newString  = String.valueOf(letters);
                        if(endSet.contains(newString)){
                            return step + 1;
                        }
                        if(wordSet.contains(newString) && !isVisited.contains(newString)){
                            isVisited.add(newString);
                            levelSet.add(newString);
                        }
                        letters[i] = temp;
                    }
                }
            }
            beginSet.clear();
            beginSet.addAll(levelSet);
            ++step;
        }
        return 0;
    }
}
