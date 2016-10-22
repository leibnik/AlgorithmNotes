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
###伪代码
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
###伪代码
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

###伪代码
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


#排序算法
##冒泡排序
假设要求的数组是正序，两两进行比较，如果前一个数比后一个数小，位置不变。
如果前一个数比后一个数大，位置互换，再跟后一个数进行比较，直到最后。第一轮比较产出一个
最大数，同时将第二轮比较的范围缩小1位，以此类推，每一轮参与比较的数据组都会产出一个“最大数”，如同冒泡一般。
###伪代码
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
###伪代码
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

###伪代码

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
