public class WordsSearch{

    public boolean exist(char[][] board, String word) {
        //使用回溯
        if (board == null || board.length == 0 || word == null) return false;
            char[] letters = word.toCharArray();
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if(board[i][j] != letters[0]) continue;
                    if (recursionFind(board, letters, 0, i, j, visited)) return true;
                }
            }
            return false;
    }

    private boolean recursionFind(char[][] board, char[] letters, int level, int row, int col, boolean[][] visited) {
        if (level >= letters.length || board[row][col] != letters[level]) return false;
        if (level == letters.length - 1) return true;
        visited[row][col] = true;
        int[] rows = new int[]{1, -1, 0, 0};
        int[] cols = new int[]{0, 0, 1, -1};
        boolean res = false;
        for (int i = 0; i < 4; i++) {
            int nRow = row + rows[i];
            int nCol = col + cols[i];
            if (nRow < 0 || nRow >= board.length || nCol < 0 || nCol >= board[nRow].length || visited[nRow][nCol] || board[nRow][nCol] != letters[level + 1]) {
                continue;
            }
            boolean success = recursionFind(board, letters, level + 1, nRow, nCol, visited);
            if (success) {
                res = true;
                break;
            }
        }
        visited[row][col] = false;
        return res;
    }
}
