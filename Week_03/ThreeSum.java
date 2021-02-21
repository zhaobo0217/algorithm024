public class ThreeSum {
public List<List<Integer>> threeSum(int[] nums) {
        //排序加双指针，排序可以跳过不合法的值，也可以滤掉重复项；时间复杂度排序O(logn),双指针最坏o(n^2)
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break; 
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1]) l++;
                    while(l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return result; 
    }
    
    public List<List<Integer>> threeSum1(int[] nums) {
        //自己方案，最后没有去重。。。时间复杂度O(n^2),空间复杂度不考虑返回结果的为O(n)
        if (nums == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            record.clear();
            for (int j = i + 1; j < nums.length; j++) {
                int cur = nums[j];
                if(record.contains(cur)){
                    int pre = -1 * cur - value;
                    List<Integer> dest = new ArrayList<>();
                    dest.add(value);
                    dest.add(pre);
                    dest.add(cur);
                    result.add(dest); 
                }else{
                    record.add((value + cur) * -1);
                }
            }
        }
        return result;
    }

}
