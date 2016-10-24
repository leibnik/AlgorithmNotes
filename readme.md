#常见算法

##分治算法

###相关文章

* [分治算法](http://www.cnblogs.com/steven_oyj/archive/2010/05/22/1741370.html)
* [算法系列总结：分而治之——分治算法](http://www.cnblogs.com/Creator/archive/2011/06/18/2084267.html)
* [Merge Sort](http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/mergeSort.htm)

###概念
```
把一个复杂的问题分成两个或更多的相同或相似的子问题，直到最后子问题可以简单的直接求解，原问题的解即子问题的解的合并
```

###例子

####归并排序

##回溯法

##贪心算法

##动态规划

##分支限界法

#数据结构
##栈
后进先出(last-in, first-out,LIFO)
```
// 判断栈是否为空
STACK-EMPTY(S)
    if S.top == 0
        return TRUE
    else return FALSE
// 压入元素
PUSH(S, x)
    S.top = S.top + 1
    S[S.top] = x
    
// 弹出元素
POP(S)
    if STACK-EMPTY(S)
        error "underflow"
    else S.top = S.top - 1
        return S[S.top + 1]
```
##队列
先进先出(first-in, first-out,FIFO)
```
//入列
ENQUEUE(Q, x)
    if QUEUE-FULL(Q)
        return
    Q[Q.tail] = x
    if Q.tail == Q.length
        Q.tail = 1
    else
        Q.tail = Q.tail + 1
    
//出列
DEQUEUE(Q)
    if QUEUE-EMPTY(Q)
        return
    x = Q[Q.head]
    if Q.head = Q.length
        Q.head = 1
    else
        Q.head = Q.head + 1
        

QUEUE-EMPTY(Q)
    if Q.head == Q.tail
        return true
    else 
        return false

QUEUE-FULL(Q)
    if Q.head == Q.tail + 1 || (Q.head == 1 && Q.tail == Q.length) 
        return true
    else
        return false
    
```
##链表
各个对象按照线性顺序进行排列的一种数据结构。数组的线性顺序由数组下标决定，而与之不同的是，链表的顺序
是由各个对象里的指针决定的。

* 单向链表：每个对象包含一个关键字 key 和一个指针 next
* 双向链表：每个对象包含一个关键字 key 和两个指针 prev 和 next ， next 指向下一个对象， prev 指向上一个对象，
同时表头 prev 为 null ，表尾 next 为 null
* 双向循环链表：在双向链表的基础上，使表头的 prev 指向表尾元素，表尾的 next 指向表头元素
* 有哨兵的双向循环链表：在双向链表的基础上，设置一个哨兵对象 L.nil ，使该对象介于表头和表尾之间，即 L.nil.next
指向表头， L.nil.prev 指向表尾，同时使表尾的 next 和表头的 prev 都指向 L.nil

以双向链表为例
```
// 搜索
LIST-SEARCH(L,k)
    x = L.head
    while x ≠ NIL and x.key ≠ k
        x = x.next
    return x

// 插入
LIST-INSERT(L, x)
    x.next = L.head
    if L.head ≠ NIL
        L.head.prev = x
    L.head = x
    x.prev = NIL
    

// 删除
LIST-DELETE(L, x)
    if x.prev ≠ NIL
        x.prev.next = x.next
    else
        L.head = x.next
    
    if x.next ≠ NIL
        x.next.prev = x.prev
        
```

##二叉树
由结点组成的数据结构，结点包含的链接可以为 null ，或指向其他结点。在二叉树中，除了根节点无父结点外
，其他的每个结点只能有一个父结点，同时每个结点都只有左右两个链接，分别指向自己的左子节点和右子节点。

##二叉搜索树
在二叉树定义的基础上，规定任何结点 x ，其左子树中的关键字最大不超过 x.key ，其右子树中的关键字最小不低于 x.key 。
* 中序遍历(inorder tree walk): 输出的子树根的关键字位于左子树的关键字值和右子树的关键字值之间。

```
INORDER-TREE-WALK(x)
    if x ≠ null
        INORDER-TREE-WALK(x.left)
        print x.key
        INORDER-TREE-WALK(x.right)
```

* 先序遍历(preorder tree walk): 输出的子树根的关键字在其左右子树的关键字值之前。

```
PREORDER-TREE-WALK(x)
    if x ≠ null
        print x.key
        PREORDER-TREE-WALK(x.left)
        PREORDER-TREE-WALK(x.right)
```

* 后序遍历(postorder tree walk): 输出的子树根的关键字在其左右子树的关键字值之后。

```
POSTORDER-TREE-WALK(x)
    if x ≠ null
        POSTORDER-TREE-WALK(x.left)
        POSTORDER-TREE-WALK(x.right)
        print x.key
```

###查找
递归查找

```
TREE-SEARCH(x,k)
    if x == NIL or k == x.key
        return x
    if k < x.key
        return TREE-SEARCH(x.left, k)
    else
        return TREE-SEARCH(x.right, k)
```

迭代查找
```
ITERATIVE-TREE-SEARCH(x, k)
    while x ≠ NIL and k ≠ x.key
        if k < x.key
            x = x.left
        else
            x = x.right
    return x
```
最小关键字元素
```
TREE-MINIMUM(x)
    while x.left ≠ NIL
        x = x.left
    return x
```

最大关键字元素
```
TREE-MAXIMUM(x)
    while x.right ≠ NIL
        x = x.right
    return x
```
后继
```
TREE-SUCCESSOR(x)
    if x.right ≠ NIL
        return TREE-MINIMUM(x, right)
    y = x.p
    while y ≠ NIL and x == y.right
        x = y
        y = y.p
    return y
```

前驱
```
TREE-PRESUCCESSOR(x)
    if x.left ≠ NIL
        return TREE-MAXIMUM(x, left)
    y = x.p
    while y ≠ NIL and x = y.left
        x = y
        y = y.p
    return y
```
**在一棵高度为 h 的二叉搜索树上，动态集合上的操作 SEARCH 、 MINIMUM 、 MAXIMUM 、 SUCCESSOR 和 PREDECESSOR 可以在 
O(h) 时间内完成。**

###插入
```
TREE-INSERT(T, z)
    y = NIL
    x = T.root
    while x ≠ NIL
        y = x
        if z.key < x.key
            x = x.left
        else
            x = x.right
    z.p = y
    if y == NIL
        T.root = z
    elseif z.key < y.key
        y.left = z
    else
        y.right = z
        
```  
###删除
从一棵二叉搜索树 T 中删除结点 z 的整个策略分为三种基本情况：
* 如果 z 没有子节点， 那么只是简单的将它删除，并修改它的父结点，用NIL作为孩子来替换 z。
* 如果 z 只有一个子节点，那么将这个孩子提升到树中 z 的位置上，并修改它的父结点，用原来 z 的孩子作为孩子来替换 z 本来的地位。
* 如果 z 有两个子节点，那么找到 z 的后继 y (一定在 z 的右子树中)，并让 y 占据树中 z 的位置。 z 的原来右子树部分成为 y 的新
的右子树，并且 z 的左子树成为 y 的新的左子树。

```
// 二叉搜索树内移动子树
TRANSPLANT(T, m, n)
    if m.p == NIL
        T.root = n
    elseif m == m.p.left
        m.p.left = n
    else 
        m.p.right = n
    if n ≠ NIL
        n.p = m.p

TREE-DELETE(T, z)
    if z.left == NIL
        TRANSPLANT(T, z, z.right)
    elseif z.right == NIL
        TRANSPLANT(T, z, z.left)
    else y = TREE-MINIMUM(z.right)
        if y.p ≠ z
            TRANSPLANT(T, y, y.right)
            y.right = z.right
            y.right.p = y
        TRANSPLANT(T, z, y)
        y.left = z.left
        y.left.p = y
```

**在一棵高度为 h 的二叉搜索树上，动态集合上的操作 INSERT 和 DELETE 的运行时间均为O(H)。**

#排序算法
##冒泡排序
假设要求的数组是正序，两两进行比较，如果前一个数比后一个数小，位置不变。
如果前一个数比后一个数大，位置互换，再跟后一个数进行比较，直到最后。第一轮比较产出一个
最大数，同时将第二轮比较的范围缩小1位，以此类推，每一轮参与比较的数据组都会产出一个“最大数”，如同冒泡一般。
```
BUBBLESORT(A){
   for i = 1 to length[A]{
       for j = length[A] downto i+1{
           if A[j] < A[j-1]{
                exchange A[j] and A[j-1]
           }
       }
   }
}
```
###算法复杂度
O(n^2)

可以通过添加一个 flag 来对冒泡算法进行优化，此时算法时间复杂度最佳为O(n)，最坏依旧为O(N^2)
```
BUBBLESORT(A){
    for i = 1 to A.length{
        flag = false
        for j = A.length downto i + 1{
            if A[j] < A[j - 1]{
                exchange A[j] and A[j - 1]
                flag = true
            }
            if flag == false{
                return
            }
        }
    }
}
```


##插入排序
插入排序就是每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。 
扑克的排序是这个算法的形象比喻：桌面上一叠未排序的扑克牌，左手拿的牌代表已排序的扑克，右手拿的表示待排序的
扑克牌，刚开始时左手牌为空（相当于已排序），抽一张牌给左手（依旧相当于已排序），从抽第二张牌开始，右手的牌
要插入左手的牌就需要与左手已经排好序的牌进行比较并插入到正确的位置。
```
INSERTION-SORT(A){
    for i = 2 to A.length {
        j = i - 1
        key = A[i]
        while j > 0 and key < A[j]{
            A[j + 1] = A[j]
            j = j- 1
        }
        A[j + 1] = key
    }
}
```
###算法复杂度
最好：O(n)
最坏：O(n^2)

##归并排序

```
MERGE-SORT(A,p,r)
    IF p < r
        THEN q = [(p + r) / 2]  //问题分解
        MERGE-SORT(A,p,q)       //继续递归直至子问题足够小
        MERGE-SORT(A,q+1,r)     //继续递归直至子问题足够小
        MERGE(A,p,q,r)          //合并解
        
MERGE(A, p, q, r)
    n1 = q - p + 1
    n2 = r - q
    let L[l..n1 + 1] and R[1..n2 + 1] be new arrays
    for i = 1 to n1
        L[i] = A[p + i - 1]
    for j = 1 to n2
        R[j] = A[q + j]
        
    L[n1 + 1] = ∞
    R[n2 + 1] = ∞
    i = 1
    j = 1
    for k = p to r
        if L[i] ≤ R[j]
            A[k] = L[i]
            i = i + 1
        else 
            A[k] = R[j]
            j = j + 1
```

###算法时间复杂度
分解问题的时间复杂度为O(logn),合并解的时间复杂度为O(n),整个算法的时间复杂度为O(nlogn)
