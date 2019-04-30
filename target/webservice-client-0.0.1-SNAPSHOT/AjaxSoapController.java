package main.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import java.io.*;

@Controller
public class AjaxSoapController {

	@RequestMapping(value = "/ajaxCommandPage", method = RequestMethod.POST)
	@ResponseBody
	public String getCommandAjax(@RequestParam(value = "soapfield", required = false) String soapField, @RequestParam(value = "wsdlfield", required = false) String wsdlField)   {
		String soapEndpointUrl = wsdlField;
		String soapAction = "";

		String soapRespose="";

		String returnName = "Нет данных";
		String returnStandard = "Нет данных";
		String returnAdress = "Нет данных";

		try {
			soapRespose=callSoapWebService(soapField, soapEndpointUrl, soapAction);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader(soapRespose)));
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("ns2:Student");

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(0);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				returnName=eElement.getElementsByTagName("ns2:name").item(0).getTextContent();
				returnStandard=eElement.getElementsByTagName("ns2:standard").item(0).getTextContent();
				returnAdress=eElement.getElementsByTagName("ns2:address").item(0).getTextContent();
			}
		}

		} catch (IOException | SAXException | ParserConfigurationException e) {
			return "";
		}

		return returnName+":"+returnStandard+":"+returnAdress;
	}

	private static void createSoapEnvelope(String soapField, SOAPMessage soapMessage) throws SOAPException {
		SOAPPart soapPart = soapMessage.getSOAPPart();

		String myNamespace = "sch";
		String sch = "http://www.howtodoinjava.com/xml/school";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration(myNamespace, sch);

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("StudentDetailsRequest", myNamespace);
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("name", myNamespace);
		soapBodyElem1.addTextNode(soapField);
	}

	private static String callSoapWebService(String soapField, String soapEndpointUrl, String soapAction) throws UnsupportedEncodingException {
		SOAPMessage soapResponse = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			// Create SOAP Connection
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			// Send SOAP Message to SOAP Server

			soapResponse = soapConnection.call(createSOAPRequest(soapField, soapAction), soapEndpointUrl);

			// Print the SOAP Response
	//	System.out.println("Response SOAP Message:");
	//		System.out.println(soapResponse.getSOAPBody().);
			soapResponse.writeTo(baos);
			//System.out.println();

			soapConnection.close();

		} catch (Exception e) {
			System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
			e.printStackTrace();
		}

		return baos.toString("UTF-8");
	}

	private static SOAPMessage createSOAPRequest(String soapField, String soapAction) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		createSoapEnvelope(soapField, soapMessage);

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.setHeader("Content-Type", "text/xml; charset=utf-8");

		soapMessage.saveChanges();

		return soapMessage;
	}
}