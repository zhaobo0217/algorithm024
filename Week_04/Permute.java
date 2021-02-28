public class Permute{

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        LinkedList<Integer> record = new LinkedList<>();
        boolean[] status = new boolean[nums.length];
        dfs(status, nums, record, res);
        return res;
    }

    private void dfs(boolean[] status, int[] nums, LinkedList<Integer> record, List<List<Integer>> res){
        if(nums.length == record.size()){
            res.add(new ArrayList<>(record));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (!status[i]){
                status[i] = true;
                record.addLast(nums[i]);
                dfs(status, nums, record, res);
                status[i] = false;
                record.removeLast();
            }
        }
    }
}
