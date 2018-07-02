package com.alibaba.dubbo.demo.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class User implements Serializable {

    private Integer id;

    @NotNull(message = "姓名不能为空")
    private String name;

    @Min(message = "年龄过小",value = 18)
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
