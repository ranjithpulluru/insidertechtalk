/*package com.client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import com.ejb.*;


public class SoapClientService {

    public static void main(String[] args) {        

        try {
            URL wsdlURL = new URL("http://localhost:8080/EJBWebService/HelloWorldImpl?wsdl");
            QName serviceName = new QName("http://ejb.com/", "HelloWorldImplService");
            QName portName = new QName("http://ejb.com/", "HelloWorldImplPort");
            Service service = Service.create(wsdlURL, serviceName);
            HelloWorld port = (HelloWorld)service.getPort(portName,HelloWorld.class);
            port.sayHello();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}*/

package com.client;

import com.ejb.HelloWorld;
import com.ejb.HelloWorldImplService;

public class SoapClientService{
	
	public static void main(String[] args) {
	   
		HelloWorldImplService service = new HelloWorldImplService();
		HelloWorld port = service.getHelloWorldImplPort();
	
		port.sayHello();
		
    }
}