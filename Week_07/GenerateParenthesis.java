public class GenerateParenthesis{

    //dfs,分支一个放左，一个放右，时间复杂度O(n^2)
    public List<String> generateParenthesis(int n) {
       List<String> res = new ArrayList<>();
       dfs(res, n, 0, 0, "");
       return res;
    }

    private void dfs(List<String> res, int n, int l, int r, String s){
        if(l == n && r == n){
            res.add(s);
            return;
        }
        if(l < n){
            dfs(res, n, l + 1, r, s + "(");
        }
        if(r < n && r < l){
            dfs(res, n, l, r + 1, s + ")");
        }
    }
}
