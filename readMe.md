

(1)使用eclipse开发

(2)maven管理jar包

(3).setting文件的存在让项目在eclipse中可以 run on server

(4)jenkins构建：生成的war包位置与maven setting配置的repository有关
       使用Deploy插件将war包部署到tomcat

(5)在jenkins配置中执行mvn install , war包首先会放到m2仓库中，如果后面配置deploy,会从target目录下copy到对应容器目录中，而非m2中

(6)在pom中的<build>中<resource>中指定“资源文件”打包路径 