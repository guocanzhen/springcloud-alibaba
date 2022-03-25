# 主工程 springcloud-alibaba

搭建服务提供者（nacos-discovery）中实现服务的注册与发现：provider-8001

搭建服务消费者（nacos-discovery）中实现服务的注册与发现+springcloud loadbalancer：consumer-8801

Nacos实现配置的统一管理和动态刷新（nacos-config）：config-client-3377

Sentinel（哨兵）-- 流控 ： sentinel-service-8401

Sentinel（哨兵）-- 熔断降级： provider-mysql-8003、consumer-mysql-8803