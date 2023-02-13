# chatgpt
chatgpt的简易java web程序
准备工作：
chatgpt账号下申请的：apiKey。获取地址：https://platform.openai.com/account/api-keys


运行方式：<br>
一、jar包直接启动<br>
  1、maven的package生成可执行jar包<br>
  2、启动jar包，命令行：java -jar chatgpt-1.0.1.jar apiKey pwd. 参数说明：apiKey为chatgpt接口生成的密钥，pwd是指定密码（可缺省），每次请求需要带上. 
     例如：java -jar chatgpt-1.0.1.jar dsadhskadhajsdk 123123 .<br>
  3、启动后进入端口根目录下有接口以及参数说明。<br><br>
  
二、docker启动<br>
  1、修改项目中带的Dockerfile，主要修改参数为java程序端口和内存设置<br>
  2、将chargpt的jar包上传至当前目录（Dckerfile位置）<br>
  2、进入linux目录，利用命令 docker build -t chagpt:v1 . 生成chatgpt镜像<br>
  3、启动镜像：docker run -d --restart=always --name chatgpt -p 8080:8080 -e key=apiKey -e pwd=pwd chagpt:v1<br><br>
  
  ps:pwd是指定密码（可缺省），如果设置了需要每次请求需要带上. <br><br>
  
打开ip:port 地址即可查看到接口url和相关参数  <br>
