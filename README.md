# SpringBoot-WebFlux
Learning [WebFlux](https://www.cnblogs.com/limuma/) Summary


# 模块介绍

## demo01
[Spring Boot WebFlux-01——WebFlux 快速入门实践](https://www.cnblogs.com/limuma/p/9315442.html)

## City-WebFlux-CRUD
[Spring Boot WebFlux-02——WebFlux Web CRUD 实践](https://www.cnblogs.com/limuma/p/9315343.html)   
系列博客的第二篇, 模拟城市作为实体对象, 进行内存 `ConCurrentHashMap` 中的CRUD操作.   

其中引入了两个新内容:   
Mono: 实现发布者, 并返回 0 或 1 个元素, 即单对象  
Flux: 实现发布者, 并返回 N 个元素, 即集合对象  

- Mono  

Mono 是什么？ 官方描述如下：A Reactive Streams Publisher with basic rx operators that completes successfully by emitting an element, or with an error.  

Mono 是响应流 Publisher 具有基础 rx 操作符，可以成功发布元素或者错误，如图所示：  
![1](http://ww1.sinaimg.cn/large/005SWfHCgy1g08dj3iselj30hs06b75n.jpg)

Mono有哪些常用方法:  
1. Mono.create(): 使用MonoSink来创建Mono
2. Mono.justOrEmpty(): 从一个Optional对象或者Null对象中创建Mono
3. Mono.error(): 创建一个只包含错误信息的Mono
4. Mono.never(): 创建一个不包含任何消息通知的Mono
5. Mono.delay(): 在指定的延时时间后, 创建Mono, 产生数字0作为唯一值.


- Flux

> Flux 最值得一提的是 fromIterable 方法，fromIterable(Iterable<? extends T> it) 可以发布 Iterable 类型的元素。当然，Flux 也包含了基础的操作：map、merge、concat、flatMap、take，这里就不展开介绍了。

Flux 是什么？官方描述如下：A Reactive Streams Publisher with rx operators that emits 0 to N elements, and then completes (successfully or with an error).  

Flux 是响应流 Publisher 具有基础 rx 操作符，可以成功发布 0 到 N 个元素或者错误。Flux 其实是 Mono 的一个补充，如图所示：
![2](http://ww1.sinaimg.cn/large/005SWfHCgy1g08dn4535nj30hs06bjt7.jpg)

- 总结  
如果知道 `Publisher ` 为 [0-1] 个, 则选择使用 `Mono`, 集合则使用 `Flux`


## City-WebFlux-MongoDB
Spring WebFlux整合MongoDB的实例项目, 通过依赖 `spring-boot-starter-data-mongodb-reactive`, 在
DAO接口中继承 `ReactiveMongoRepository`, 就可以获得一些已定义的CRUD方法直接使用即可.