package com.webservices.client2;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * 通过客户端编程的方式调用Webservice服务
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        URL wsdlUrl = new URL("http://localhost:8081/helloService?wsdl");
        Service s = Service.create(wsdlUrl, new QName("http://webservices.com/","MyService"));
        MyService hs = s.getPort(new QName("http://webservices.com/","HelloServicePort"), MyService.class);
        String sayHello = hs.sayHelloOperate("zhangsan");
        System.out.println(sayHello);
        String ret = hs.sayGoodbye("zhangsan");
        System.out.println(ret);
        String ret2 = hs.sayHelloNoR("zhangsan","男");
        System.out.println(ret2);
    }
}