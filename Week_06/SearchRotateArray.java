public class SearchRotateArray{

    public int search(int[] nums, int target) {
        //暴力法，直接遍历，时间复杂度为O(n),此题推荐O(logn),那只有二分法了；但是数组是旋转过的，通过二分结果，可以得到，至少有一半是有序的，我们可以先判断在没在有序的那部分里，没有的话去另一半寻找，直到结束时间复杂度为O(logn),没有额外的空间，空间复杂度为O(1)
        if(nums == null) return -1;
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) >> 1;
            if(nums[mid] == target) return mid;
            if(nums[l] <= nums[mid]){
                //前半部分有序
                if(nums[l] <= target && nums[mid] > target) r = mid - 1;
                else l = mid + 1;
            }else {
                //后半分有序，同理
                if(nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}
