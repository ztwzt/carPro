# carPro   总结
设计：
    分层：
    controller--跳转页面，处理请求
    service--处理业务逻辑，处理数据
    dao--对数据的逻辑操作
     为什么：高内聚：分层的设计可以简化系统设计，让不同的层专注做某一模块的事
            低耦合：层与层之间通过接口或API来交互，依赖方不用知道被依赖方的细节
            复用：分层之后可以做到很高的复用
            扩展性：分层架构可以让我们更容易做横向扩展
    
技术栈：layui+ssm
     实现验证码：
                CaptchaUtil.createLineCaptcha('','','','');
     图片输入输出：
                ImageIO.read(inputStream);
                ImageIO.write(outputStream);
     文件上传与下载：
                下载:
                    发出请求->找到路径->封装ResposeEntity 实体对象(bytes,HttpHeaders,HttpStatus )—>返回ResposeEntity
                上传：
                    上传文件->设置暂存标志->返回上传对象->提交->去除暂存标志(database实际存储的是路径，文件再服务器里存储）
                    springmvc: <bean id="multipartResolver" class="CommonsMultipartResolver">
                    File 文件类:File file=new File() 构建文件夹对象
                    Ramdom 类
     参数处理： @JsonFormat 格式化请求参数(时间) 
               @DateTimeFormat 格式化返回参数(时间)
               @JsonProperty 更改返回属性名
     
       
       
                      
                    
     
        
