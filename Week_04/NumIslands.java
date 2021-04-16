public class NumInlands{

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        //时间复杂度O(n*m),空间复杂度最快O(1)，最慢O(n)
        int res = 0;
        for(int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == '1'){
                    ++res;
                    dfs(grid, r, c);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
