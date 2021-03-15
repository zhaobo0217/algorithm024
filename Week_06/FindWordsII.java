public class FindWordsII{

    
    public List<String> findWords(char[][] board, String[] words) {
        //首先我们需要组建一个前缀树trie数，然后遍历回溯寻找符合的单词
        List<String> res = new ArrayList<>();
         if(board == null || board.length == 0 || words  == null) return res;
         TrieNode root = new TrieNode();
         for(String word : words){
             if(word == null || word.length() == 0) continue;
             TrieNode cNode = root;
             for(char c : word.toCharArray()){
                 if(cNode.childNodeMap.containsKey(c)){
                     cNode = cNode.childNodeMap.get(c);
                 }else{
                     TrieNode  node = new TrieNode();
                     cNode.childNodeMap.put(c, node);
                     cNode = node;
                 }
             }
             cNode.value = word;
         }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(root.childNodeMap.containsKey(board[i][j])){
                    //剪枝应该提前，之前放在递归里面，时间较长
                    recursionFind(board, root, i, j, res);
                }
            }
        }
        return res;
    }

    private void recursionFind(char[][] board,TrieNode node, int row, int col,List<String> res){
        char c = board[row][col];
        TrieNode childNode = node.childNodeMap.get(c);
        if(childNode == null) return;
        if(childNode.value != null){
            res.add(childNode.value);
            childNode.value = null;
        }
        //暂时将此位置替换为非字母字符，一字母只能使用一次
        board[row][col] = '#';
        int[] rows = new int[]{-1, 0, 1, 0};
        int[] cols = new int[]{0, 1, 0, -1};
        for(int i = 0; i < 4; i++){
            //从四个方向回溯
            int nRow = row + rows[i];
            int nCol = col + cols[i];
            if(nRow < 0 || nRow >= board.length 
                || nCol < 0 || nCol >= board[row].length) 
                continue;
            if(childNode.childNodeMap.containsKey(board[nRow][nCol])){
                recursionFind(board, childNode, row + rows[i], col + cols[i], res);
            }
        }
        //恢复清除数据
        board[row][col] = c;
        //到此说明末尾节点也没成功，移除
        if(childNode.childNodeMap.isEmpty()){
            node.childNodeMap.remove(c);
        }
    }


    class TrieNode {
        HashMap<Character, TrieNode> childNodeMap = new HashMap<>();
        String value = null;
    }
}
