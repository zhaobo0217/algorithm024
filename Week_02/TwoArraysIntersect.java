class TwoArraysIntersect {
	public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        HashMap<Integer, Integer> record = new HashMap<>();
        //先找出两者长度最小的为nums1,以较小的长度记录节省hashMap空间支出，同时也可以在较长循环中，记录为empty后终止循环
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        for (int i = 0; i < nums1.length; i++) {
            int value = nums1[i];
            int count = record.getOrDefault(value, 0);
            record.put(value, count+1);
        }
        int index = 0;
        for (int i= 0; i < nums2.length; i++) {
            if (record.isEmpty()){
                break;
            }
            int value = nums2[i];
            int count = record.getOrDefault(value, 0);
            if(count > 0){
                nums1[index++] = value;
                record.put(value, count - 1);
            }else {
                record.remove(value);
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        //首先现将两个数组排序，然后建立两个指针，指向两个数组的最小元素，分别比较对应指针元素，谁小移动谁，相同即为重合元素，拷贝到数组的一段，指针移动到最后，循环结束，拿到数组一端的元素即为两个数组的交集的元素集合
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = 0;
        int l2 = 0;
        int index = 0;
        while (l1 < nums1.length && l2 < nums2.length) {
            if (nums1[l1] < nums2[l2]) {
                l1++;
            }else if (nums1[l1] > nums2[l2]) {
                l2++;
            }else {
                nums1[index++] = nums1[l1];
                l1++;
                l2++;
            }
        }
        return Arrays.copyOfRange(nums1,0,index);
    }

}
