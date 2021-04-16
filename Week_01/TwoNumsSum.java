public class TwoNumsSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return new int[0];
        HashMap<Integer,Integer> record =new HashMap<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (record.containsKey(value)){
                nums[index++] = record.get(value);
                nums[index++] = i;
                record.remove(value);
            }else{
                record.put(target - value, i);
            }
        }
        return Arrays.copyOfRange(nums,0,index);
    }
}
