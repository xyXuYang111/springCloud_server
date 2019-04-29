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

