### Dubbo 简介
> Dubbo |dʌbəʊ|
是由阿里巴巴开源的基于Java的高性能RPC框架。
与许多RPC系统一样,dubbo基于定义服务的想法,
指定可以使用参数和返回类型远程调用的方法。
dubbo是阿里巴巴开源的一个SOA服务治理解决方案
###Dubbo架构图
![Image text](./dubbo-architecture.png)
###服务端:
服务器实现此接口并运行一个dubbo服务器来处理客户端调用。
####客户端:
客户端有一个存根(stub)，提供与服务器相同的方法。
####Maven dependency(依赖)本次我使用最新版2.6.0，可根据需要选择版本
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>dubbo</artifactId>
    <version>2.6.0</version>
</dependency>

####接口定义(dubbo-demo-api模块)
因为服务提供者和服务消费者依赖于相同的接口，
强烈建议把接口定义在一个分离的模块，
可以由服务提供模块和服务消费模块共享。
####服务提供者(dubbo-demo-provider模块)
####服务消费者(dubbo-demo-consumer模块)

###环境说明
jdk 1.8 (1.8.0_144) \
springboot 1.5.10 \
Maven 3.3.3
###项目启动
1. 首先启动服务提供者模块(dubbo-demo-provider)
2. 然后启动服务消费者模块(dubbo-demo-consumer)
3. 最后通过接口调试工具(例如:postman)调用服务消费模块中的测试接口