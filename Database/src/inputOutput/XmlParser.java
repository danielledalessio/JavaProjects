/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputOutput;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author danielledalessio
 */
public class XmlParser {
    private ConnectionData ConnectionData;
    private Document document;
    
    public XmlParser(String file)
    {
        parseXmlFile(file);
    }
    
    private void parseXmlFile(String fileName)
    {
        //get the DOM Builder Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        try
        {
            //get instance of document builder using factory
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            //load and parse XML document
            document = db.parse(ClassLoader.getSystemResourceAsStream(fileName));
            
            //iterate through nodes and extract data
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            
            for(int i = 0; i < nodeList.getLength(); i++)
            {
                /** get the <driver> element*/
                Node node = nodeList.item(i);
                
                if(node instanceof Element)
                {
                    //get text or int value for each <driver> element
                    String type = node.getAttributes().getNamedItem("type").getNodeValue();
                    //create new connection data
                    ConnectionData = new ConnectionData();
                    ConnectionData.setType(type);
                    
                    NodeList childNodes = node.getChildNodes();
                    
                    //identifying child tag of employee encountered
                    for(int j = 0; j < childNodes.getLength(); j++)
                    {
                        Node cNode = childNodes.item(j);
                        
                        if(cNode instanceof Element)
                        {
                            String content = cNode.getLastChild().getTextContent().trim();
                            switch (cNode.getNodeName())
                            {
                                case "url":
                                    ConnectionData.setUrl(content);
                                    break;
                                case "ipaddress":
                                    ConnectionData.setIpaddress(content);
                                    break;
                                case "port":
                                    ConnectionData.setPort(content);
                                    break;
                                case "database":
                                    ConnectionData.setDatabase(content);
                                    break;
                                case "login":
                                    ConnectionData.setLogin(content);
                                    break;
                                case "password":
                                    ConnectionData.setPassword(content);
                                    break;
                            }
                        }
                    }
                }
            }
        }
    
    catch(ParserConfigurationException pce)
    {
        pce.printStackTrace();
    }
    catch(SAXException se)
    {
        se.printStackTrace();
    }
    catch(IOException ioe)
    {
        ioe.printStackTrace();
    }
    }
    
    public ConnectionData getConnectionData()
    {
        return ConnectionData;
    }
}
