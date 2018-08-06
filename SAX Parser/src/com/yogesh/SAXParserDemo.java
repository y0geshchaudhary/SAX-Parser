package com.yogesh;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXParserDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File file = new File("src\\com\\yogesh\\Student.txt");
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		UserHandler_Basic userHandler = new UserHandler_Basic();
		parser.parse(file, userHandler);
	}

}
