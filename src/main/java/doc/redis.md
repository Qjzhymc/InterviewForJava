1. redis持久化方案有哪些？rdb和aof
rdb持久化是通过创建快照的方式，以压缩的二进制文件形式保存数据，会保存某个时间点的全量数据，是redis默认的持久化方式，有手动触发和自动触发两种触发方式：
aof持久化会记录所有写指令，以append的形式追加到aof文件中，在服务器下次启动的时候，就可以通过重新读取aof文件中的指令并执行，来还原到服务器关闭前的状态。
可以在redis.conf配置文件中指定aof缓冲区写入文件的频率。一般都是每秒钟保存一次。

如果aof文件不断增大，会通过aof文件重写的方式解决文件不断增大的问题，原理是首先会fork一个子进程，子进程读取当前数据库的状态重写一个新的aof文件，
redis主进程会将新的变动同时写到aof重写缓冲区和原来的aof缓冲区，子进程重写aof完成后，主进程会调用信号处理函数将aof重写缓冲区内容写到新的aof文件，
替换掉原来的aof文件。

rdb优点：快照文件会比较小，恢复数据比较快
缺点：如果服务器宕机，会丢失掉上一次rdb持久化后的数据，
aof的优点：aof追加文件的方式对服务器性能影响比较小，速度比rdb快，
缺点：生成的文件比较大，恢复数据的速度比rdb慢

2. redis线程模型有哪些？ 单线程为什么快？
redis的线程模型主要有四个部分，首先是有多个socket套接字与多个客户端连接，然后会有一个io多路服用程序，io多路服用程序将消息压入队列，交给文件事件分派器处理，
文件事件分派器会关联不同的事件处理器，有连接应答处理器，命令请求处理器，命令回复处理器。
因为文件事件分派器队列的消费是单线程的，所以redis也叫单线程模型。
为什么快：1.数据存放在内存中，内存操作比磁盘io读取快；2. 单线程省去了很多上下文切换的时间，不存在竞争条件，不用考虑各种锁的问题，不存在加锁释放锁操作
 3.redis的线程模型使用了io多路服用程序处理并发的连接请求；4.数据结构简单，

3. redis的过期键有哪些删除策略
如何确定一个键是否过期：首先检查这个键是否在过期字典中，如果在的话，取出这个键的过期时间和unix时间戳比较，是不是过期
删除策略有：
定时删除：在设置键的过期时间时，创建一个定时器，到达过期时间时通过定时器删除这个键
惰性删除：每次获取键的时候判断是否过期，如果过期就删除并返回空，
定期删除：每隔一段时间就对数据库中的键检查，如果过期就删除
redis实际使用的是惰性删除+定期删除的策略

4. redis缓存如何回收？
当redis缓存达到上限之后怎么办？
内存淘汰策略：分为key值不进行淘汰(直接相应错误)，key值发生淘汰回收内存两种，设置了过期时间的数据处理
（volatile-lru（使用lru最近最少使用算法）,volatile-random, volatile-ttl（过期时间越早先删除）,volatile-lfu（使用lfu算法））
所有数据中处理(allkeys-lru, allkeys-random, allkeys-lfu)

6. redis集群方案有哪些？
主从复制模式（读写分离）：
哨兵模式：可以实现自动化的系统监控和故障恢复（主从切换）功能
cluster模式：每台redis存储不同数据，无中心结构，集群每个节点都是对等的关系，每个节点保存各自的数据和整个集群的状态，每个节点都和其他所有节点相连，数据分散存储

7. redis事务是如何实现的？redis为什么不支持回滚？
主要通过MULTI，EXEC，WATCH三个命令实现的，其中MULTI用于开启事务，exec用于提交事务，watch用于监视任意数量的key。
multi开启事务后，除了这几个命令之外的命令都会进入事务队列，当用exec执行事务的时候，会遍历事务队列，执行事务队列的所有命令，最后将命令执行的结果返回给客户端。

8. redis主从复制的原理？
第一步：从节点会设置需要同步的主节点的信息，包括机器ip，端口，
第二部：从服务器会同主服务器建立socket连接，
第三步：从节点发送ping命令检查socket连接是否可用，以及主节点当前是不是能处理请求，
第四部：如果主从节点有设置密码的话，会进行身份验证，从节点向主节点发送身份验证，如果设置了不同的密码或其中一方没有设置密码会重试
第五部：同步状态，从节点发送psync命令到主节点进行全量复制或部分复制。
第六部：同步之后进入命令传播阶段，在这个阶段主节点会将自己执行的写命令发送给从节点，保证主从节点数据的一致性。

9. 缓存雪崩，缓存击穿，缓存穿透，缓存预热如何解决？
缓存雪崩：redis的大量key在同一时间过期，大量请求访问数据库，导致服务出现问题
解决方案：设置过期时间时加上一个随机时间避免同一时间失效

缓存穿透：指访问的数据在redis和数据库中都没有，如果有大量这样的请求也会对数据库产生压力，一般会出现在攻击中。
解决方案：在接口层增加校验，比如用户鉴权，参数校验，不合法的参数直接return，
还有redis会有一个布隆过滤器，可以防止缓存穿透的发生，

缓存击穿：是指一个非常热点的key，有大并发集中对这个key请求，当这个key在失效的时候，会直接请求数据库，
解决方案：设置热点key永远不过期，