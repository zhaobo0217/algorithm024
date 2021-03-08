public class ThreeNumsSum{

    public List<List<Integer>> threeSum(int[] nums) {
        //这道题的做法是排序加双指针；也可以使用两数之和方式；
       List<List<Integer>> res = new ArrayList<>();
       if(nums == null) return res;
        Arrays.sort(nums);
        int l, r;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) break;
            //这一步很重要，不滤掉会有重复数据
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            l = i + 1;
            r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[++l]);
                    while(l < r && nums[r] == nums[--r]);
                }else if(sum > 0){
                    while(l < r && nums[r] == nums[--r]);
                }else{
                    while(l  < r && nums[l] == nums[++l]);
                }
            }
        }
        return res;
    }
}
