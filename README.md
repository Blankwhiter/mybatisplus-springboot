# mybatisplus-springboot 
该项目主要实现mybatisplus、多数据源、lombok、druid的集成

主要参考 https://mp.baomidou.com/guide/quick-start.html


flyway默认执行sql脚本放置：db/migrate
sql脚本的格式：V+版本号 +双下划线+功能+_+描述+结束符(.sql) 

flyway命令
 - migrate：把数据库迁移到最新版本，迁移是根据 db/migration 目录下的脚本 顺序 执行。
 - clean： 清空 数据库中的数据， 不能在生产环境使用此命令 。
 - info：打印出版本迁移信息。
 - validate：验证要执行的迁移脚本。
 - baseline：为已经存在的数据库建立基线，迁移数据库将建立在基线的基础上。
 - repair：修复 flyway_schema_histry 表。

目录结构说明：
```xml
├─main
│  ├─java
│  │  └─com
│  │      └─example
│  │          └─mybatisplus
│  │              ├─config(mybatisplus配置文件以及shiro认证相关)
│  │              ├─controller(访问类)
│  │              ├─entity(实体类)
│  │              ├─exception(异常拦截器)
│  │              ├─filter(过滤器，存放着跨域过滤器)
│  │              ├─mapper(mapper类)
│  │              └─service(服务定义类)
│  │                  └─impl(服务实现类)
│  └─resources
│      └─db
│          └─migration(flyway数据库脚本文件)
└─test
    └─java
        └─com
            └─example
                └─mybatisplus(测试mybatisplus)
```
