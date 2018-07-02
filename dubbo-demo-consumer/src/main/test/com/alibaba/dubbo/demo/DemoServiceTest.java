package com.alibaba.dubbo.demo;

import com.alibaba.dubbo.demo.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/META-INF/spring/dubbo-demo-consumer.xml")
public class DemoServiceTest {

    @Autowired
    DemoService demoService;

    @Test
    public void sayHello() {
    }

    @Test
    public void createUser() {
        User user = new User();
        user.setAge(19);
//        user.setName("tm");
        String str = demoService.createUser(user);
        System.out.println(str);
    }
}
