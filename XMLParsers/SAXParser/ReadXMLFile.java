package saxparser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFile {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		// Obtain and configure a SAX based parser
		SAXParserFactory factory = SAXParserFactory.newInstance();

		// obtain object for SAX parser
		SAXParser saxParser = factory.newSAXParser();

		/*
		 * DefaultHandler for SAX handler class All three methods are written in
		 * handlers body
		 */
		DefaultHandler handler = new DefaultHandler() {

			boolean bname = false;
			boolean bprice = false;
			boolean bdescription = false;
			boolean bcalories = false;

			// This method is calle eery time the parser get the open tag < >
			// Identifies which tag is being open at time by assigning an open
			// flag
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {

				if (qName.equalsIgnoreCase("name")) {
					bname = true;
				}

				if (qName.equalsIgnoreCase("price")) {
					bprice = true;
				}

				if (qName.equalsIgnoreCase("description")) {
					bdescription = true;
				}

				if (qName.equalsIgnoreCase("calories")) {
					bcalories = true;
				}
			}

			// This is called every time the parser gets a closing tag
			public void endElement(String uri, String localName, String qName) throws SAXException {

			}

			// Print data stored in between <start> and </end> tags
			public void characters(char ch[], int start, int length) throws SAXException {

				if (bname) {
					System.out.println("name : " + new String(ch, start, length));
					bname = false;
				}
				if (bprice) {
					System.out.println("price : " + new String(ch, start, length));
					bprice = false;
				}
				if (bdescription) {
					System.out.println("description : " + new String(ch, start, length).trim());
					bdescription = false;
				}
				if (bcalories) {
					System.out.println("calories : " + new String(ch, start, length));
					bcalories = false;
				}

			}

		};

		saxParser.parse("sample.xml", handler);
	}

}
