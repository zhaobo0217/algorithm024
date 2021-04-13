public class AllOrderNum{

    //基础的回溯，步骤 终止条件、处理当前、下一层、恢复数据；需要一个visited，存储已访问的元素，时间复杂度为O(n*n!),空间复杂度为O(n)，递归深度；
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        permute(res, nums, 0, new LinkedList<Integer>(), new boolean[nums.length]);
        return res;
    }

    private void permute(List<List<Integer>> res, int[] nums, int level, List<Integer> cur, boolean[] isVisited){
        if(level == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(isVisited[i]) continue;
            cur.add(nums[i]);
            isVisited[i] = true;
            permute(res, nums, level + 1, cur, isVisited);
            isVisited[i] = false;
            cur.remove(Integer.valueOf(nums[i]));
        }
    }
}
