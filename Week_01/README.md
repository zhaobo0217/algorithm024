## 学习笔记

### 数组、链表、跳表

#### 数组
数组 ArrayList 内部Object[]数组存储所有的元素，基础操作都是在原数组上进行扩容，拷贝；
- 默认不传capacity 相当于与 objectData = {}
- 扩容规则 有一个默认的size = 10，每次扩容 = oldsize + oldsize >> 1; 最后一次扩容如果大于Integer.MAX_VALUE - 8 直接等于Integer.MAX_VALUE(也是ArrayList的最大值，如果数据量巨大要考虑其他的数据结构)
+ 关于增删改查 System.arraycopy(src, srcPos, dest, destPos, length);将原数组的起始位置len长度，拷贝到目标数组对应位置的 长度；增删改查也主要是建立在这个函数的基础上，有此克制查改可以使O(1)的，增删却是O(n)的。末尾add除外；

总结下： ArrayList主要是一个Object[] + size 类似容器和边界；动态扩容，数组拷贝完成增删改查；一个疑惑数组扩容后并没有减容，但是提供了trimToSize，可以将数组恢复到当前实际size的大小，但是是给外部调用的；如果不回收，那么会不会一直占用大量的内存？答案是不会的，如果是基础的数据结构，系统会给默认值 如int[1024] 那么它肯定是会一直占用内存的，但是Object[] 中存储的只是堆中对象的栈地址，移除后不再引用堆数据将会被GC，不会造成内存的浪费


#### 链表

LinkedList 内部是以节点的形式存在的 与数组最大的区别是 不再需要扩容的逻辑了 直接连接连接链表就可以了；记录size；
- 使用Node来存储数据 双向链表
  ```
  private static class Node<E> {
      E item;
      Node<E> next;
      Node<E> prev;

      Node(Node<E> prev, E element, Node<E> next) {
          this.item = element;
          this.next = next;
          this.prev = prev;
      }
  }
  ```
- 实现Deque接口 双向队列
    ```
      public void addFirst();
      public void addLast();

      //没有元素的时候会抛出异常 NoSuchElementException
      public E removeLast();
      public E removeFirst();

      public E offerFirst();
      public E offerLast();

      public E pollFirst();
      public E pollLast();

      public E peekFirst();
      public E peekLast();

      //deque 同时具有stack的一些方法
      //添加在队列的头部 具有栈的属性
      public void push(E e);
      public E pop();
      public E peek();

      //双向队列继承了queue 同时也拥有queue的方式

      public void add();
      //会抛出异常
      public E remove();
      public E offer();
      public E poll();
      public E peek();
      //与peek方法类似 但是没有元素 会抛出异常
      public E element();

    ```

- LRU Cache 功能 LinkedHashMap已经实现了lru cache的功能 linkedlist稍加改造也可以 使用到的直接进入队列放入头部，超过边界的话移除尾部元素；

总结下：由于内部使用链表的形式实现的，因此系统将queue deque 的接口都放入了其中；他的增删是O(1)的时间复杂度；缺点是查询只能遍历需要O(n)的时间复杂度；但是内部做了小优化 size更接近尾部的话从尾部查，真实的遍历次数不会超过n >> 1 一半


#### 栈
LIFO 先进后出的数据结构 自己常用的是java.util.Stack<E>
主要的方法：
```
//向栈中推入元素
public E push(E e);
//移除一并返回栈顶的元素
public E pop();
//查看儿不移除栈顶的元素
public E peek();
```
查看源码知道Stack实际继承了Vector;java 的代码并没有单独为栈建立接口类有链表的时候知道，Deque接口也承担了所有栈的操作，所以我们也可可以直接只用LinkedList来处理栈；
Vector类似于ArrayList只不过是线程安全的，所有的操作均由synchronized修饰；vertor的内部是数组，push操作实际是将当前的元素添加到数组的尾部；pop拿到数组尾部元素并且删除 ；peek就是拿到数组尾部元素 自己使用数组来实现一个简单的栈的时候就是这样；
由于Stack是线程安全的结构，我们平时可以使用ArrayDeque 数据结构 代码注释中说Faster than Stack and faster than LinkedList;等下面弄完队列在一块探明ArrayDeque的原理；

#### 队列
FIFO先进先出的数据结构；直接查找源码Queue；可以发现不同于stack，队列有单独的接口声明；
```
//add 和offer是添加元素操作 区别add在无法继续添加的时候会抛出异常
boolean add(E e);
boolean offer(E e)
//remove和poll移除操作 没有元素会抛出异常
E remove();
E poll();
//两个查看 element()会抛出异常
E peek();
E element();

```

#### 题目

<ul>
<li><a href="https://leetcode-cn.com/problems/two-sum/" rel="noopener nofollow" target="_blank">两数之和</a>（近半年内，字节跳动在面试中考查此题达到 152 次）</li>
<li><a href="https://leetcode-cn.com/problems/container-with-most-water/" rel="noopener nofollow" target="_blank">盛最多水的容器</a>（腾讯、百度、字节跳动在近半年内面试常考）</li>
<li><a href="https://leetcode-cn.com/problems/move-zeroes/" rel="noopener nofollow" target="_blank">移动零</a>（华为、字节跳动在近半年内面试常考）</li>
<li><a href="https://leetcode.com/problems/climbing-stairs/" rel="noopener nofollow" target="_blank">爬楼梯</a>（阿里巴巴、腾讯、字节跳动在半年内面试常考）</li>
<li><a href="https://leetcode-cn.com/problems/3sum/" rel="noopener nofollow" target="_blank">三数之和</a>（国内、国际大厂历年面试高频老题）</li>
</ul>

#### 参考链接
<ul>
<li><a href="http://developer.classpath.org/doc/java/util/ArrayList-source.html" rel="noopener nofollow" target="_blank"> Java 源码分析（ArrayList）</a></li>
<li><a href="http://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/" rel="noopener nofollow" target="_blank"> Linked List 的标准实现代码</a></li>
<li><a href="http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java" rel="noopener nofollow" target="_blank"> Linked List 示例代码</a></li>
<li><a href="http://developer.classpath.org/doc/java/util/LinkedList-source.html" rel="noopener nofollow" target="_blank"> Java 源码分析（LinkedList）</a></li>
<li>LRU Cache - Linked list：<a href="http://leetcode-cn.com/problems/lru-cache" rel="noopener nofollow" target="_blank"> LRU 缓存机制</a></li>
<li>Redis - Skip List：<a href="http://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html" rel="noopener nofollow" target="_blank">跳跃表</a>、<a href="http://www.zhihu.com/question/20202931" rel="noopener nofollow" target="_blank">为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？</a></li>
</ul>
