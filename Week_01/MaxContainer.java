class MaxContainer {
    public int maxArea(int[] height) {
        if (height == null) return 0;
	int l = 0;
	int r = height.length - 1;
	int maxArea = 0;
	while (l < r) {
	    int lBar = height[l];
	    int rBar = height[r];
	    maxArea = Math.max(maxArea, Math.min(lBar, rBar) * (r - l));
	    if (lBar < rBar) l++;
	    else r--;
	}
	return maxArea;
    }

}
