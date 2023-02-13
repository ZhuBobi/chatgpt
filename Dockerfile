 ## 基础镜像java
FROM openjdk:8
 ## 作者是JuBobi
MAINTAINER Jubobi
 ## 就是你上传的jar包的名称。给jar包起个别名
ADD chatgpt-1.0.1.jar chatGpt.jar
 ## 就是在容器中以多少端口号运行
EXPOSE 8080
 ## 容器启动之后执行的命令即启动jar
CMD exec java -Xms4G -Xmx4G $JAVA_OPTS -Dfile.encoding=UTF-8 -jar chatgpt.jar ${key} ${pwd} --server.port=8080
