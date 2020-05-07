package com.client;

import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class SaajClient 
{
	public static void main(String[] args) throws UnsupportedOperationException, SOAPException, IOException {
		
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory.createConnection();
		String url = "http://localhost:8080/EJBWebService/HelloWorldImpl?wsdl";
		
		MessageFactory messageFactory = MessageFactory.newInstance();
		 SOAPMessage soapMessage = messageFactory.createMessage();
		 SOAPPart soapPart = soapMessage.getSOAPPart();
   	         SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
   	         soapEnvelope.addNamespaceDeclaration("ejb", "http://ejb.com/");
		 SOAPBody soapBody = soapEnvelope.getBody();
		 SOAPElement soapElement = soapBody.addChildElement("sayHello", "ejb");
		 
		 soapMessage.saveChanges();
		 
		// output the message
		    System.out.println( "\n============= start request msg ==========\n" );
		    soapMessage.writeTo( System.out );
		    System.out.println( "\n============= end request msg ==========\n" );
		    
		    SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
			
			soapConnection.close();
	}

	

}
