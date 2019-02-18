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
[Spring Boot WebFlux-03——WebFlux 整合 MongoDB](https://www.cnblogs.com/limuma/p/9315467.html)
Spring WebFlux整合MongoDB的实例项目, 通过依赖 `spring-boot-starter-data-mongodb-reactive`, 在
DAO接口中继承 `ReactiveMongoRepository`, 就可以获得一些已定义的CRUD方法直接使用即可.

## City-WebFlux-Thymeleaf  
[Spring Boot WebFlux-04——WebFlux 整合 Thymeleaf](https://www.cnblogs.com/limuma/p/9315483.html)  
[Spring Boot WebFlu-05——WebFlux 中 Thymeleaf 和 MongoDB 实践](https://www.cnblogs.com/limuma/p/9315495.html)

WebFlux和Thymeleaf的一个简单应用, 用于展示存入MongoDB数据库中的内容.

## City-WebFlux-Redis
[Spring Boot WebFlux-06——WebFlux 整合 Redis](https://www.cnblogs.com/limuma/p/9315507.html)  
[Spring Boot WebFlux-07——WebFlux 中 Redis 实现缓存](https://www.cnblogs.com/limuma/p/9315512.html)  

一些基础的关于缓存的操作, 和MVC模式下几乎没有区别的操作.  

目前，@Cacheable 等注解形式实现缓存没有很好的集成，二者 Mono / Flux 对象没有实现 Serializable，无法通过默认序列化器，解决方式是需要自定义序列化，这里通过手动方式与 Redis 手动集成，并实现缓存策略。  

参考《缓存更新的套路》，缓存更新的模式有四种：Cache aside、Read through、Write through、Write behind caching。  

这里使用的是 Cache Aside 策略，从三个维度（摘自耗子叔叔博客）：  

- 失效：应用程序先从 Cache 取数据，没有得到，则从数据库中取数据，成功后，放到缓存中。
- 命中：应用程序从 Cache 中取数据，取到后返回。
- 更新：先把数据存到数据库中，成功后，再让缓存失效。
