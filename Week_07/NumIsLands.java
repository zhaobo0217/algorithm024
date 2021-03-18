public class NumIsLands{

    public int numIslands(char[][] grid) {
        //DFS，遇到‘1’岛屿数目+1，然后dfs将与之相邻的位置标记为已访问；循环遍历即可，时间复杂度O(mn),时间复杂度O(m*n)
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean[][] isVisited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isVisited[i][j]) continue;
                if(grid[i][j] == '1'){
                    ++res;
                    markIslands(grid, i, j, isVisited);
                }
            }
        }
        return res;
    }

    private void markIslands(char[][] grid, int r, int c, boolean[][] isVisited){
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0' || isVisited[r][c]){
                return;
            }
            isVisited[r][c] = true;
            markIslands(grid, r + 1, c, isVisited);
            markIslands(grid, r, c + 1, isVisited);
            markIslands(grid, r - 1, c, isVisited);
            markIslands(grid, r, c - 1, isVisited);
        }
}
