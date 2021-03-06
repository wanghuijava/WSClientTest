package com.webservices.client;

//文件名：HelloService.java

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "HelloService", targetNamespace = "http://webservices.com/")
@XmlSeeAlso({
    
})
public interface HelloService {
	
    @WebMethod
    @WebResult(name = "myReturn", targetNamespace = "")
    @RequestWrapper(localName = "sayHelloOperate", className = "com.webservices.client.SayHello")
    @ResponseWrapper(localName = "sayHelloOperateResponse", className = "com.webservices.client.SayHelloResponse")
    public String sayHelloOperate(
        @WebParam(name = "userName")
        String arg0);
    

    
    public String sayGoodbye(String name);

}