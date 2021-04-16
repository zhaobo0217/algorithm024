class ClimbStairs {
	//爬楼梯问题可以查看规律比如一节台阶的话只能有一种上法，2节的话可以选择一次爬，也可以选择一次一次一节，共两种方法，第三节我们可以看到如果已经爬了2节的话再爬一节，和爬了一节然后跨两节这两种方式可以推导出公式f(n) = f(n-1) + f(n-2);同斐波那契数列；因为只需要结果我们只需要记录前一次和前两次数据即可；
	public int climbStairs(int n) {
		if (n <= n) return n;
		int f1 = 1;
		int f2 = 2;
		for (int i = 3; i <= n; i++) {
			int cur = f1 + f2;
			f1 = f2;
			f2 = cur;
		}
		return f2;
 	}
}
