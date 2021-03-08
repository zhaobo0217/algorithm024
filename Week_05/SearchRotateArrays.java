public class SearchRotateArrays{

    public int search(int[] nums, int target) {
        if(nums == null) return -1;
        return recursion(nums, 0, nums.length - 1, target);
    }

    public int search1(int[] nums, int target) {
        //此题没有构成2分法的2要素，有序和边界；但是局部可以是有序的，我们将数组分成两半，至少有一半是有序的，可以根据其中一半的头部元素是不是大于尾部来判断当前是不是有序的，时间复杂度为O(logn),空间复杂度为O(1)
        if(nums == null) return -1;
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) >> 1;
            if(target == nums[mid]) return mid;
            if(nums[l] <= nums[mid] ){
                if(nums[l] <= target && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            }else{
                if(nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }

    private int recursion(int[] nums, int l, int r, int target){
        if(l > r) return -1;
        int mid = (l + r) >> 1;
        if(nums[mid] == target) return mid;
        if(nums[l] <= nums[mid]){
            if(target >= nums[l] && target < nums[mid]){
                return recursion(nums, l, mid - 1, target);
            }else {
                return recursion(nums, mid + 1, r, target);
            }
        }else{
            if(target > nums[mid] && target <= nums[r]){
                return recursion(nums,mid + 1, r, target);
            }else {
                return recursion(nums,l, mid - 1, target);
            }
        }
    }
}
