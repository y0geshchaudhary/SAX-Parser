package com.yogesh;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler_Basic extends DefaultHandler {

	boolean bFirstname = false;
	boolean bLastname = false;
	boolean bNickname = false;
	boolean bMarks = false;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if(bFirstname) { System.out.println("Firstname : "+new String(ch, start, length)); bFirstname = false; }
		else if (bLastname) { System.out.println("Lastname : "+new String(ch, start, length));  bLastname= false; }
		else if (bNickname) { System.out.println("Nickname : "+new String(ch, start, length)); bNickname= false; }
		else if (bMarks) { System.out.println("Marks: "+new String(ch, start, length)); bMarks= false; }
		
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("The END.");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (("student").equalsIgnoreCase(qName))
			System.out.println("End of Student.");

	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("We are starting reading document now.");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (("student").equalsIgnoreCase(qName)) {
			String rollnum = attributes.getValue("rollno");
			System.out.println("Roll no = " + rollnum);
		} else if (("firstname").equalsIgnoreCase(qName))
			bFirstname = true;
		else if (("lastname").equalsIgnoreCase(qName))
			bLastname = true;
		else if (("nickname").equalsIgnoreCase(qName))
			bNickname = true;
		else if (("marks").equalsIgnoreCase(qName))
			bMarks = true;

	}

}
