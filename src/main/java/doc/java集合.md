# Java集合
---

###### java有哪些集合？

java中的集合主要分为Collection和Map两大类，Collection接口下又分为Set、List、Queue。  
* Set下的子类有HashSet、LinkedHashSet、TreeSet；  
* List下的子类有ArrayList、LinkedList、Vector、Stack；  
* Queue下的子类有PriorityQueue、ArrayDeque；
* Map下的子类有HashMap、LinkedHashMap、HashTable、TreeMap。

---

###### Set、List、Queue、Map这些集合有什么区别？
* Set表示元素是无序的、不可重复的；
* List表示元素是有序、可重复的；
* Queue表示元素按加入顺序排列，元素是有序、可重复的；
* Map存储的是键值对；
---

###### 这些集合框架底层数据结构都是哪些？
* List：ArrayList底层是Object[]数组；LinkedList底层是双向链表；Vector底层也是Object[]数组；
* Set：HashSet底层是基于HashMap实现，使用HashMap保存元素；LinkedHashSet是HashSet的子类，内部是通过LinkedHashMap实现的；TreeSet(有序、唯一)底层是红黑树；
* Queue：PriorityQueue底层是通过Object[]数组实现二叉堆；ArrayQueue底层是Object[]数组+双指针

---
# List集合

---

###### ArrayList和Vector的区别？
ArrayList和Vector都是数组实现的，区别就是Vector是线程安全的  

---

###### ArrayList和LinkedList的区别？
* 底层数据结构上：ArrayList是数组存储数据，LinkedList是用双向链表实现的；  
* 线程安全上：两个都不是线程安全的；  
* 快速随机访问：ArrayList实现了RandomAccess接口，支持快速的随机访问，可以通过元素的下标序号快速获取元素对象，而LinkedList不支持高效的随机数据访问；
(一般项目中都是使用ArrayList，很少使用LinkedList)

---

###### 谈谈ArrayList的扩容机制？

首先ArrayList底层是通过动态数组实现的，数组初始大小是10。一直添加元素，当数组size大小已经要溢出的时候会调用grow()方法扩容，扩容后新容量是原来的1.5倍，然后通过Arrays.copyOf()方法扩大数组容量返回新数组。

---
# Set集合

---

###### Comparable和Comparator的区别？

* Comparable是java.lang包下的一个接口，可以重写它的compareTo(Object obj)方法用来排序
* Comparator是java.util包下的一个接口，可以重写它的compare(Object obj1, Object obj2)方法用来排序

---

###### 比较HashSet、LinkedHashSet、TreeSet的区别

* HashSet、LinkedHashSet、TreeSet都是Set接口的实现类，都能保证元素唯一，并且都不是线程安全的；
* 主要区别在于底层数据结构不同，HashSet的底层数据结构是哈希表（基于HashMap实现）。LinkedHashSet的底层数据结构是链表和哈希表，元素的插入和取出顺序满足FIFO。TreeSet底层数据结构是红黑树，元素是有序的，排序的方式有自然排序和定制排序。
* HashSet用于不需要保证元素插入和取出顺序的场景，LinkedHashSet用于保证元素的插入和取出顺序满足FIFO的场景。TreeSet用于支持对元素自定义排序规则的场景。

---

# Queue

---

###### Queue和Deque的区别

* Queue是单端队列，只能从一端插入元素，另一端删除元素，实现上一般遵循先进先出规则。Queue里的插入删除方法有两种，根据操作失败的处理方式分为两种，一种是直接抛出异常，一种返回特殊值。
add(),remove(),element()这些方法失败的时候会抛出异常，offer(),poll(),peek()这些方法失败的时候会返回特殊值。

* Deque是双端队列，在队列的两端都可以插入或删除元素。Deque扩展了Queue的接口，增加了在队首和队尾进行插入和删除的方法，同样根据失败后处理方式的不同分为两种。

---

###### ArrayDeque和LinkedList有什么区别？

ArrayDeque和LinkedList都实现了Deque接口，都具有队列都功能。不同点是：   
* ArrayDeque是基于可变长数组和双指针实现都，而LinkedList是通过链表实现的；
* ArrayDeque不支持存储NULL数据，但LinkedList支持；
* ArrayDeque插入时可能存在扩容过程，LinkedList不需要扩容；    
从性能角度上，用ArrayDeque实现队列要比LinkedList更好。而且ArrayDeque也可以用来实现栈。

---

###### 说一说PriorityQueue？

PriorityQueue是在JDK1.5中被引入的，和Queue的区别在于元素出队顺序是与优先级相关的，优先级最高的元素先出队。

* PriorityQueue利用了二叉堆的数据结构来实现，底层使用可变长的数组来存储数据；
* PriorityQueue通过堆元素的上浮和下沉，实现在O(logn)的时间复杂度内插入元素和删除堆顶元素；
* PriorityQueue是非线程安全的，而且不支持存储NULL和non-comparable的对象；
* PriorityQueue默认是小顶堆，但可以接收一个Comparator作为构造参数，从而来自定义元素优先级但先后。

堆排序、求第K大的数、带权图的遍历

---

# Map接口

---

###### HashMap与Hashtable的区别?

* 线程是否安全：HashMap是非线程安全的，Hashtable是线程安全的，Hashtable内部的方法基本都经过synchronized修饰。
* 效率：方面，因为线程安全的问题，HashMap要比Hashtable效率高一点。另外Hashtable基本被淘汰，不要在代码中使用。
* 对Null key和Null value的支持：HashMap可以存储null的key和value，但是null作为键只能有一个，null作为值可以有很多个；Hashtable不允许有null键和null值，否则会抛出NullPointerException；
* 初始容量和扩充容量：1，创建时如果不指定容量初始值，Hashtable默认的初始大小为11，之后每次扩充，容量变为原来的2N+1。HashMap默认的初始大小是16，之后每次扩充容量变为原来的2倍。2，创建时如果给定了初始值，Hashtable会直接使用给定的大小，而HashMap会将容量扩充为2的幂次方大小。
* 底层数据结构：JDK1.8之后的HashMap在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为8）的时候，将链表转化为红黑树（链表转化为红黑树之前会先判断，如果当前数组的长度小于64，那么会先进行数组扩容，而不是转化红黑树），Hashtable没有这样的机制。

---

###### HashMap与HashSet区别？

HashSet底层就是基于HashMap实现的。

---

###### HashMap和TreeMap区别

TreeMap和HashMap都继承子AbstractMap类，但是TreeMap还实现了NavigableMap接口和SortedMap接口，所以TreeMap可以对集合内元素搜索，可以对集合元素按键排序。

---

###### HashMap的底层数据结构是？

JDK1.8之前HashMap是有数组+链表组成的，每一个数组的成员是一个链表，链表主要是为了解决哈希冲突。JDK1.8以后的HashMap在解决哈希冲突的时候，会判断当来链表长度大于阈值时，会将链表转化为红黑树，以减少搜索时间，这个阈值默认是8，而且在将链表转换成红黑树前会先判断，如果当前数组的长度小于64，那么会选择先进行数组扩容，而不是装换为红黑树。

HashMap默认的初始化大小是16，之后每次扩容，容量变为原来的2倍，而且HashMap总是使用2的幂作为哈希表的大小。


---

###### HashMap的底层实现

在JDK1.8之前HashMap的底层是用数组加链表来实现的，HashMap插入键值对的时候，首先通过key的hashcode经过扰动函数处理后得到hash值，然后通过（n-1）& hash判断当前元素存放的位置，如果当前位置存在元素的话，就判断该元素和要存入的元素的hash值以及key是够相同，如果相同的话说明是同一个key，直接覆盖新的键值对，不相同就通过拉链法解决冲突。
(扰动函数就是hash()函数，防止一些实现比较差的hashcode()方法，可以减少碰撞)
拉链法就是把链表和数组相结合，创建一个数组，数组中每一格就是一个链表，如果有遇到哈希冲突，就把冲突的值加到链表中。
在JDK1.8之后的版本，解决哈希冲突的时候，如果链表长度大于阈值（默认是8），会把链表转化为红黑树，减少搜索时间。链表转化为红黑树之前也会先判断一下，如果当前数组的长度小于64，那么就先进行数组扩容，而不是转化红黑树。

结合源码看的话，1.首先执行put方法添加键值对，会调用putVal(),在putVal()方法里会判断链表长度大于8的时候，调用treeifyBin方法；2.然后在treeifyBin()方法里面先判断数组长度是不是需要真的转化红黑树，然后转化为红黑树。

---

###### HashMap的长度为什么是2的幂次方

因为计算key的hashcode后，需要用链表长度取余hashcode值得到要插入的位置，取余操作一般用%实现，但是为了提高计算的效率，可以用(n-1)&hash值代替，因为取余操作中如果除数是2的幂次则等价于与除数减一的与操作。所以用二进制的&操作代替取余操作提高运算效率。

---

###### loadFactor加载因子？

loadFactor加载因子是控制数组存放数据的疏密程度，loadFactor越趋近于1，表示数组中（Entry）存放的数据就越多，也就越密，会让链表的长度增加，loadFactor越小，数组中存放的数据就越少。
loadFactor太大的话会导致查找元素效率低，太小的话会导致数组利用率低，默认值是0.75f。
当数组需要扩容的时候，会涉及到rehash、复制数据等操作，会非常消耗性能。

---

###### threshold？

threshold是衡量数组是否需要扩容的一个标准，threshold=capacity*loadFactor，当size>=threshold时候，就要对数组扩容了。

---

###### HashMap的7中遍历方式？

---

###### ConcurrentHashMap与Hashtable的区别？

ConcurrentHashMap和Hashtable主要在实现线程安全性的方式上有不同。
* 底层数据结构：JDK1.7的ConcurrentHashMap底层是采用分段的数组+链表实现的，JDK1.8和HashMap1.8一样，数组+链表/红黑树。Hashtable和JDK1.8之前的HashMap的底层数据结构一样采用数组+链表的形式；
* 实现线程安全的方式（重要）：在JDK1.7的时候，ConcurrentHashMap对整个桶数组进行了分割分段（Segment，分段锁），首先有一个Segment数组，数组里每个元素是一个HashEntry数组，HashEntry数组的每个元素是链表，所以会对Segment数组里每个节点加锁，每一把锁只锁其中一部分数据，多线程访问容器里不同数据段的数据，就不会存在锁竞争，提高并发访问率。
到了JDK1.8的时候，ConcurrentHashMap已经摈弃了Segment的概念，而是直接用Node数组+链表+红黑树的数据结构实现，直接对数组上的每个Node加锁，并发控制使用synchronized和CAS来操作。
* Hashtable使用synchronized来保证线程安全，效率比较低，当一个线程访问同步方法时，其他线程访问这个同步方法会进入阻塞或轮询状态.

---

###### JDK1.7和JDK1.8的ConcurrentHashMap实现有什么不同？

* 线程安全实现方式不同
* hash碰撞解决方法不同
* 并发度不同

在JDK1.8之前，一个ConcurrentHashMap里包含一个Segment数组，Segment的大小默认是16，所以默认同时支持16个线程并发写。Segment的结构和HashMap类似，是一种数组+链表结构，一个Segment包含一个HashEntry数组，每个HashEntry是一个链表结构的元素，每个Segment守护一个HashEntry数组里的元素，当对HashEntry数组的元素进行修改时，必须首先获得对应的Segment的锁。
JDK1.8之后，取消了Segment分段锁，采用Node节点数组+CAS+synchronized来保证并发安全，数据结构和HashMap类似，数组+链表/红黑树。链表超过一定阈值（默认是8）也会转化为红黑树。
在JDK1.8之后，锁粒度更细，synchronized只锁定当前链表或红黑树的首节点，这样只要hash不冲突，就不会产生并发，就不会影响其他Node的读写，效率会提升很多。

---

# 使用集合需要注意的地方？

---

###### 集合判空

判断所有集合是否为空，使用isEmpty()，而不是用size()==0的方式。

---

###### 集合转Map

在使用java.util.stream.Collectors类的toMap()方法转为Map集合时，一定要注意当value为null时会抛出NPE异常。

` 
bookList.stream().collect(Collectors.toMap(Person::getName, Person::getPhoneNumber));
`

---

###### 集合遍历

不要在foreach循环里进行元素的remove/add操作。remove元素请使用Iterator方式，如果并发操作，需要对Iterator对象加锁。
（如果是java 8开始，也可以用removeIf()方法删除满足特定条件的元素。

---

###### 集合去重

可以利用Set元素唯一的特性，快速对一个集合进行去重操作，避免使用List的contains()方法进行遍历去重或者判断包含操作。

---

###### 集合转数组
###### 数组转集合

使用集合转数组的方法，必须使用集合的toArray(T[] array),传入的是类型完全一致，长度为0的空数组。

使用工具类Arrays.asList()把数组转集合时，不能使用其修改集合相关的方法，他的add/remove/clear方法会抛出UnsupportedOperationException异常。

---

###### 如何正确的将数组转换为ArrayList？

* 手动实现工具类

* 将Arrays的ArrayList内部类转换为ArrayList

`List list = new ArrayList<>(Arrays.asList("a", "b", "c"));`

* 使用java8的Stream（推荐）

`Integer[] myArray = {1, 2, 3};
List myList = Arrays.stream(myArray).collect(Collectors.toList());`

* 使用Guava

`List<String> myList = ImmutableList.copyOf(myArray);//不可变集合

List<String> myList = Lists.newArrayList(myArray);//可变集合`

* 使用Apache Commons Collections

`List<String> myList = new ArrayList<>();
CollectionUtils.addAll(myList, myArray);`

* 使用java9的List.of()方法

`List<String> myList = List.of(myArray);`

---



