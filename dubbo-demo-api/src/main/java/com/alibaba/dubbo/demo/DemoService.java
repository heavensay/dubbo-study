/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.demo;

import com.alibaba.dubbo.demo.bean.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Path,@Consumes,@GET等标签用于支持restful风格的远程调用。如果消费端不是dubbo调用，这些annotation可以放到实现类中
 */
@Path("demo")
public interface DemoService {

    @Path("sayHello")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    @GET
    String sayHello(@QueryParam(value = "name") String name);

    @Path("createUser")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    @GET
    String createUser(User user);

}