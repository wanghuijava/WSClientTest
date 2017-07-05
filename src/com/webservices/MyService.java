package com.webservices;


/**
 * WebService client
 */
public class MyService {
    
    public String sayHello(String name){
        return  "hello: " + name;
    }
    
    public String sayGoodbye(String name){
    
        return  "goodbye: " + name;
    }
    
    public String sayHello2(String name){
        return "hello " + name;
    }


}