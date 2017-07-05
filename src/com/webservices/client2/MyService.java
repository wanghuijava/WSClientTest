package com.webservices.client2;

//文件名：HelloService.java

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


/**
 * 
 */
@WebService(name = "HelloService", targetNamespace = "http://webservices.com/")
public interface MyService {
	
    @WebMethod
    @WebResult(name = "myReturn")
    public String sayHelloOperate(@WebParam(name = "userName") String arg0);
    @WebMethod
    public String sayHelloNoR(@WebParam(name = "userName") String arg0, @WebParam(name = "sex") String arg2);
    
    public String sayGoodbye(String name);

}