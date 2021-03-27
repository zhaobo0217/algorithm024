public class RalativeSortArray{

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //思路以arr2为标尺，遍历arr1，移动相同元素到一端，排序剩余元素，时间复杂度O（mn + (n - m)log(n - m)）
        if(arr2 == null || arr2.length == 0 || arr1 == null || arr1.length == 0) return arr1;
        int p = 0;
        for(int num : arr2){
            for(int i = p; i < arr1.length; i++){
                if(arr1[i] == num){
                    int temp = arr1[p];
                    arr1[p++] = arr1[i];
                    arr1[i] = temp;
                }
            }
        }
        if(p < arr1.length){
            Arrays.sort(arr1, p, arr1.length);
        }
        return arr1;
    }
}
