public class JumpII{

  public int jump(int[] nums) {
        //这道题应该使用贪心，我第一次使用递归超过时间限度；从第0的位置开始记录一下最远的范围，范围的最远定位下一次范围，每一个范围为一步；时间复杂度为O(n),空间复杂度为O(1)
        if(nums == null) return 0;
        int distance = 0;
        int edge = 0;
        int steps = 0;
        //这里是从第一个位置开始的，总长度 - 1
        for(int i = 0; i < nums.length - 1; i++){
            distance = Math.max(distance, i + nums[i]);
            if(i == edge){
                edge = distance;
                ++steps;
            }
        }
        return steps;
    }
}
