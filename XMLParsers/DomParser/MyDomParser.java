package domparser;

import java.io.IOException;

/* https://www.youtube.com/watch?v=HfGWVy-eMRc */
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyDomParser {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//Document builder factory->factory class that allow to crewte a document builder object
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//parsing the document
		Document doc = builder.parse("people.xml"); //java.w3c.dom , SAXException,IOException
		
		//get NodeList of all person tag
		NodeList personNodeList = doc.getElementsByTagName("person");
		
		//itterate through 
		int k = personNodeList.getLength();
		for(int i=0;i<personNodeList.getLength();i++){
			Node p = personNodeList.item(i);	//these nodes can be any Element node, commnet node, attribute node,Document node,text node
			if(p.getNodeType()==Node.ELEMENT_NODE){	//dont getChildNode
				Element person = (Element) p;
				String id = person.getAttribute("id");
				
				//get childnodes details under each person
				NodeList nameList = person.getChildNodes();
				for(int j=0;j<nameList.getLength();j++){
					Node n = nameList.item(j);
					if(n.getNodeType()==Node.ELEMENT_NODE){
						Element name = (Element) n;
						System.out.println("Person "+id+":"+name.getTagName() + "="+ name.getTextContent());
					}
				}
				
			}
		}
		//root node> element node>text node , comment node
		
		
	}

}
