## 学习笔记

### 数组、链表、跳表

#### 数组
数组 ArrayList 内部Object[]数组存储所有的元素，基础操作都是在原数组上进行扩容，拷贝；
- 默认不传capacity 相当于与 objectData = {}
- 扩容规则 有一个默认的size = 10，每次扩容 = oldsize + oldsize >> 1; 最后一次扩容如果大于Integer.MAX_VALUE - 8 直接等于Integer.MAX_VALUE(也是ArrayList的最大值，如果数据量巨大要考虑其他的数据结构)
+ 关于增删改查 System.arraycopy(src, srcPos, dest, destPos, length);将原数组的起始位置len长度，拷贝到目标数组对应位置的 长度；增删改查也主要是建立在这个函数的基础上，有此克制查改可以使O(1)的，增删却是O(n)的。末尾add除外；

总结下： ArrayList主要是一个Object[] + size 类似容器和边界；动态扩容，数组拷贝完成增删改查；一个疑惑数组扩容后并没有减容，但是提供了trimToSize，可以将数组恢复到当前实际size的大小，但是是给外部调用的；如果不回收，那么会不会一直占用大量的内存？答案是不会的，如果是基础的数据结构，系统会给默认值 如int[1024] 那么它肯定是会一直占用内存的，但是Object[] 中存储的只是堆中对象的栈地址，移除后不再引用堆数据将会被GC，不会造成内存的浪费 

#### 参考链接
<ul>
<li><a href="http://developer.classpath.org/doc/java/util/ArrayList-source.html" rel="noopener nofollow" target="_blank"> Java 源码分析（ArrayList）</a></li>
<li><a href="http://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/" rel="noopener nofollow" target="_blank"> Linked List 的标准实现代码</a></li>
<li><a href="http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java" rel="noopener nofollow" target="_blank"> Linked List 示例代码</a></li>
<li><a href="http://developer.classpath.org/doc/java/util/LinkedList-source.html" rel="noopener nofollow" target="_blank"> Java 源码分析（LinkedList）</a></li>
<li>LRU Cache - Linked list：<a href="http://leetcode-cn.com/problems/lru-cache" rel="noopener nofollow" target="_blank"> LRU 缓存机制</a></li>
<li>Redis - Skip List：<a href="http://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html" rel="noopener nofollow" target="_blank">跳跃表</a>、<a href="http://www.zhihu.com/question/20202931" rel="noopener nofollow" target="_blank">为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？</a></li>
</ul>
