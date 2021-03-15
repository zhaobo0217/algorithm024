public class NumSubMat{

    public int numSubmat(int[][] mat) {
        //首先先找出行的位置前的最大连续数，，然后取到当前位置，再从列有下往上依次加上较小值，时间复杂度为O(m^2 * n)，空间复杂度为O(mn)
        if(mat == null || mat.length == 0) return 0;
        int row = mat.length;
        int col = mat[0].length;
        int[][] record = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(j == 0) record[i][j] = mat[i][j];
                else if(mat[i][j] == 1) record[i][j] = record[i][j - 1] + 1;
                else record[i][j] = 0;
            }
        }
        int res = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int value = record[i][j];
                for(int k = i; k >= 0 && value != 0; k--){
                    value = Math.min(value, record[k][j]);
                    res += value;
                }
            }
        }
        return res;
    }
}
