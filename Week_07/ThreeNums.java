public class ThreeNums{

    public List<List<Integer>> threeSum(int[] nums) {
        //循环+双指针；难点过滤重复数据，排序+重复数字跳过；时间复杂度为O(n^2)
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            //剪枝有一个数大于0,和肯定大于0了
            if(nums[i] > 0) break;
            //滤重
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //滤重+移动指针
                    while(l < r && nums[l] == nums[++l]);
                    //滤重+移动指针
                    while(l < r && nums[r] == nums[--r]);
                } else if(sum > 0){
                    //滤重+移动指针
                    while(l < r && nums[r] == nums[--r]);
                }else{
                    //滤重+移动指针
                    while(l < r && nums[l] == nums[++l]);
                }
            }
        }
        return res;
    }  
}
