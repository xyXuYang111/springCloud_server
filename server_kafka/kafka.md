# kafka的使用

### 集成
* java方式集成：看demo
* yml方式集成：不想了解

### 使用
对于elastic的使用：存在两种方式:
* [spring-data-elastic] 这种是基于spring的自己整合的工具jar，它只能实现根据它自己的条件进行elastic的操作。很呆板
* [elastic原生语句] 第二种是通过elastic的原生语句做的，这个灵活，一般是以elastic为主库的人公司。很复杂

### 案例
* 本demo只是集成的elastic的那套逻辑，对于原生的elastic没有去了解
* 详细介绍查看file下的文本，对elastic有介绍

### 集成是注意
* elastic的服务版本和它提供的jar包版本是1-1对于的，如果你用6.3.1，一定要找6.3.1的服务端

