public class MajorityElement{

    public int majorityElement(int[]  nums){
        //方法1。时间复杂度O(n),空间复杂度O(n)
        int count = 1 , value = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(value == nums[i]){
                ++count;
            }else if (--count == 0){
                value = nums[i];
                count = 1;
            }
        }
        return value;
    }

    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> record = new HashMap<>();
        //时间复杂度O(n),空间复杂度O(n)
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int value = 1;
            if(record.containsKey(nums[i])){
                value = record.get(nums[i]) + 1;
            }
            record.put(nums[i],value);
            if(value > result[0]){
                result[0] = value;
                result[1] = nums[i];
            }
        }
        return result[1];
    }
}
