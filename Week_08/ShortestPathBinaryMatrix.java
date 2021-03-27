public class ShortestPathBinaryMatrix{

    //BFS,双向BFS，A*,双向A*;当前时间复杂度O(n),空间复杂度O(n),尝试了国际站A*,时间并没有提升，感觉自己并没有找到启发式的key，还需要再尝试之后；双向BFS的版本会尝试下;
    if(grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{0, 0});
        int res = 1;
        int[] dx = new int[]{1, 0, 1, -1, 0, 1, -1, -1};
        int[] dy = new int[]{0, 1, 1, 0, -1, -1, 1, -1};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
               int[] value = queue.poll();
                if(value[0] == m - 1 && value[1] == n -1){
                    return res;
                }
                for(int j = 0; j < 8; j++){
                    int nX = value[0] + dx[j];
                    int nY = value[1] + dy[j];
                    if(nX < 0 || nY < 0 || nX >= m || nY >= n  || grid[nX][nY] == 1 || visited[nX][nY]) continue;
                    queue.offer(new int[]{nX, nY});
                    visited[nX][nY] = true;
                }
            }
            res++;
        }
        return -1;
    }
}
