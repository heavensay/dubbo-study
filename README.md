# dubbo-study
dubbo pratice demo 


##Rest支持
使我们的服务支持rest风格访问

- 添加rest maven支持  
```xml
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>dubbo-rpc-rest</artifactId>
            <version>${dubbo.version}</version>
        </dependency>
```  
- provider端配置支持rest
```xml
    <!-- 会启动tomcat监听8888端口，用于rest接口 -->
    <dubbo:protocol name="rest" port="8888" threads="500" contextpath="services" server="tomcat" accepts="500" />
    <!-- declare the service interface to be exported -->
    <dubbo:service interface="com.alibaba.dubbo.demo.DemoService" ref="demoService" validation="true" protocol="dubbo,rest"/>
```
上述配置同提供端同时支持dubbo、rest两种协议访问

- 访问服务  
   - 浏览器通过rest接口访问即可
`
http://127.0.0.1:8888/services/demo/sayHello?name=tom
`

  - 客户端采用dubbo来访问rest服务
    
  客户端跟平常一样，引入服务即可，如果提供端支持多种协议，可选择其中一种即可。
```
<dubbo:reference id="demoService" check="false" interface="com.alibaba.dubbo.demo.DemoService" protocol="rest"/>
```
 访问方式跟默认请求rpc服务一样
 
`
String result = demoService.sayHello("world"); 
`

客户端采用dubbo方式来访问，那么提供服务的api中需要有rest注释来标识元信息：@Path，@Consumes...
```
/**
 * @Path,@Consumes,@GET等标签用于支持restful风格的远程调用。如果消费端不是dubbo调用，这些annotation可以放到实现类中
 */
@Path("demo")
public interface DemoService {

    @Path("sayHello")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    @GET
    String sayHello(@QueryParam(value = "name") String name);
}
```
