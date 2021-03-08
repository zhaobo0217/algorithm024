public class SearchMatrix{

    if (matrix == null || matrix.length == 0) return false;
        //这道题满足单调性和边界，第一感觉是使用二分查找，但是是数组，第一次我采用了2个二分，先找出行，再二分找出列，时间复杂度为O(logm + logn) = O(logm*n),运行下时间和内存都不错，但是代码有些长；看题解看到可以将二维看成一维数组，恍然大悟写出如下,时间复杂度 O(logm*n)，代码简洁了一半
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0, r = row * col - 1;
        while(l <= r){
            int mid = (l + r) >> 1;
            int num = matrix[mid / col][mid % col];
            if(num == target)return true;
            else if(num > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
