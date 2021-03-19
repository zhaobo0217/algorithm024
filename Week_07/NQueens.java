public class NQueens{

    public List<List<String>> solveNQueens(int n) {
       List<List<String>> res = new ArrayList<>();
       if(n <= 0) return res;
       char[][] boards = new char[n][n];
       //构建出棋盘
       for(int i = 0; i < n; i++){
           for(int j = 0; j < n; j++){
               boards[i][j] = '.';
           }
       }
       backtrace(boards, 0, n, res);
        return res;
    }
    
    private void backtrace(char[][] boards, int row, int n, List<List<String>> res){
        if(row == n){
            //添加棋盘
            res.add(charArrayToStringList(boards));
            return;
        }
        for(int col = 0; col < n; col++){
            //判断当前位置是否可以放
            if(isValid(boards, n, row, col)){
                boards[row][col] = 'Q';
                backtrace(boards, row + 1, n, res);
                boards[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] boards, int n, int r, int c){
        //判断当前是不是可以放
        for(int i = 0; i < r; i++){
            for(int j = 0; j < n; j++){
                //如果当前位置是Q,逐行添加的话，行不需要判断，列相同 c == j，斜线相同i + j == r + c;反斜线相同 j - i == c - r;
                if(boards[i][j] == 'Q' && (c == j || r + c == i + j || r + j == i + c)) return false;
            }
        }
        return true;
    }

    private List<String> charArrayToStringList(char[][] boards){
        List<String> res = new ArrayList<>();
        for(char[] board : boards){
            res.add(String.valueOf(board));
        }
        return res;
    }
}
