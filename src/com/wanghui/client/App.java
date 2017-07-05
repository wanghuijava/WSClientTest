package com.wanghui.client;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 通过UrlConnection调用Webservice服务
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        //服务的地址
        URL wsUrl = new URL("http://localhost:8081/helloService");
        
        HttpURLConnection conn = (HttpURLConnection) wsUrl.openConnection();
        
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        
        OutputStream os = conn.getOutputStream();
        
        //请求体
        String soap = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q0=\"http://webservices.com/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" + 
                      "<soapenv:Body><q0:sayHello><arg0>wanghui</arg0></q0:sayHello></soapenv:Body></soapenv:Envelope>";
        
        os.write(soap.getBytes());
        
        InputStream is = conn.getInputStream();
        
        byte[] b = new byte[1024];
        int len = 0;
        String s = "";
        while((len = is.read(b)) != -1){
            String ss = new String(b,0,len,"UTF-8");
            s += ss;
        }
        System.out.println(s);
        
        is.close();
        os.close();
        conn.disconnect();
    }
}