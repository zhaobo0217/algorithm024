public class MaxArea{

    public int maxArea(int[] height) {
        //双指针法，建立左右两个指针，计算面积，得出最大面积；难点在于之后如何移动指针问题，可以使用假设法面积A = min(l, r)*t;有次公式我们得知，只要移动，t'一定要减少，可以枚举出l>r l<r的移动方案，最终得出只能移动较小的边界，才可能得到更大的面积；时间复杂度为O(n),空间复杂度O(1)
        if(height == null || height.length == 0) return 0;
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r){
            res = Math.max(Math.min(height[l], height[r]) * (r - l), res);
            if(height[l] <= height[r]) l++;
            else r--;
        }
        return res;
    }
}
