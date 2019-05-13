# ecache内存使用

### 使用ecache
ecache配置有两种配置方式:
* java的方式：通过注解加载配置文件实现这个效果
* 通过yml的方式：不建议使用这种方式：你不会明白他的流程已经自定义对这块的控制

### 注解介绍
* [@Cacheable] 查询出来的结果存储注解
* [@CacheEvict]  删除缓存
* [@CachePut] 更新缓存

### 使用
* 想demo

###原理
* ecache的原理
   在ecn项目中有个map实现静态缓存的效果，就是用map实现缓存技术。而所谓的ecache应该是也和这个差不多，都是通过map来实现。
   那么我是不是可以这样理解：所谓的ecache---就是一个map====》hashMap技术。而一个ecacheName就是一个空间。而这个空间里面存放的就是
   存放的是缓存。
       缓存的list：应该就是一个map
       更新缓存：可以理解为清空map
   ecache.xml应该设计的就是map的存活时间
   
网上介绍：
   1.       ehcache使用了LinkedHashMap来存放Element。jdk要1.5以上。Ehcache1.5可以使用jdk1.4
   如果在添加Elemtent时，缓存中的Element个数达到了最大缓存数并且overflowToDisk配置的属性为true，Ehcache会更具配置项MemoryStoreEvictionPolicy的失效策略将Element输出到磁盘。如果overflowToDisk为fasle，Ehcache将删除内存中Element
   值得注意的是缓存中失效的Element并不会别马上清理掉，所以想得到内存的真实大小应该调用方法calculateInMemorySize()方法。
   一个ehcache.xml对应一个CacheManager
   不同的缓存应该对应不同的硬盘上的路径，否则会报错
   注意要想使用磁盘缓存，缓存的Element必须实现序列化接口。否则会抛出NotSerializableException异常。
   Ehcache会将每个缓存配置的文件路径下创建一个cache_name.data文件，如果使用的磁盘持久化技术，还会生成一个cache name.index文件。
   8.       Ehcache有一个后台线程专门做Ellment失效监测以及清除工作。设置线程运行间隔时间，可通过设置diskExpiryThreadIntervalSeconds属性来完成，此值不宜设置过低，否则会导致清理线程占用大量CPU资源。默认值是120秒。
   9.       持久化可在Element的diskPersistent配置项中配置，如果配置为“false”或是“omitted”在CacheManager shutdown或是startup后，用来缓存Element的文件将被清除掉。如果设置为“true”，data和index文件会被保存下来，对于新创建的CacheManager Element也是可用的。
   使用时必须显示调用cache. Flush()才会将数据缓存到磁盘中。
   磁盘缓存步骤：从MemoryStore中把没有失效的Element刷新到DiskStore，Element被写入到data文件，Element将被序列化到index文件。
   12.   磁盘缓存大小默认是没有限制的，不过可通过maxElementsOnDisk来指定。当磁盘缓存达到maxElementsOnDisk指定的值时，Ehcache会清理磁盘中的缓存使用默认策略是LFU（使用频率最低）。
   13.   在使用完Ehcache后，必须要shutdown缓存。Ehcache中有自己的关闭机制，不过最好在你的代码中显示调用CacheManager.getInstance().shutdown();
   14.   Cache:对于getValue()能取到可序列化的值；getObjectValue()取得非序列化的值
   15.   cache.getSize();得到缓存中元素的个数；获得当前MemoryStore中的element数量：cache.getMemoryStoreSize();获得当前DiskStore中element数量：cache.getDiskStoreSize();
   16.   在使用完Ehcache后，必须要shutdown缓存。Ehcache中有自己的关闭机制，不过最好在你的代码中显示调用CacheManager.getInstance().shutdown();
   17.   ehcache-core-1.6—1.7没有任何依赖；ehcache1.7.1依赖SLF4J，以及相应的log的jar包。
   18.   CacheManager可以通过单例（factory的静态方法）或者构造函数（constructors）创建。分别叫做single model和instance model。当两种情况都有的时候，系统会采用单例模式，构造器每次都生成单例模式
   19.   对于想存储数据到硬盘，或者集群时复制到其他缓存区域的数据，必须可序列化。如果不可序列化，该数据在进行上述操作时会被丢弃，且没有报错，只是在debug级别有日志信息。
   
   
按照上面的介绍：
    我们可以这种理解：ecahce就是：quartz/tesk + map 实现的缓存。
    
知道了：一个hashMap就是一个ecacheName
        而里面的key就是map的key，参数就是object
        而每一个定义的xml其实就是在创建一个hashMap。根据规则定时去清空。理论上应该是定时清空
        
总结：ecache就是一个hashMap(按照官方设计：他是linkHashMap)，每一个ecache.xml你可以理解为一个map的大小和map的存活时间。每次通过id
      去寻找缓存，可以理解为，通过key去寻找map的value。而缓存的小时时间，可以理解内置一个quartz。他会根据ecache.xml规则定时去清空
      map再去生成一个新的ecache的map。

用到的设计模式：按照饿汉模式做的。可以去尝试仿写，不需要去实现注解的方式。·

再次总结：通过单例模式，保证数据的唯一性，至于具体的实现效果。需要看他们的源码。然后通过静态map实现缓存效果。


引发问题：
   静态块：它在jvm虚拟机是一个独立的模块：静态块。它是存放被static所修饰的方法。被static所修饰的方法，它并不需要进行初始化的操作
   构造方法：它是jvm对类的初始化操作的初始化操作
   由于静态块和构造方法之间存在区别，而静态块是不需要被jvm进行加载，执行顺序是：静态块》构造方法

