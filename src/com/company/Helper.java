package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

public class Helper {
    public static Document getDocument() {
        // create Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();// to use document builder
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();//to parse document
            //Get Document
            Document document = builder.parse(new File("E:\\FCAI\\4th\\1st term\\SOA\\JAVA ASSIGNMENTS\\FIRST\\data.xml"));
            return document;
            //normalize
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public static Document createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();// to use document builder
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.newDocument();
        return document;
    }
    public static  void saveToXml(Document doc,String path){
        TransformerFactory transformerFactory=TransformerFactory.newInstance();
        try {
            Transformer transformer =transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            //StringWriter sw =new StringWriter();
            StreamResult sr=new StreamResult(path);
            DOMSource source =new DOMSource(doc);
            transformer.transform(source,sr);

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
//    public static  int countDuplicate(String id){
//        int count =0;
//        Document document =Helper.getDocument();
//        NodeList bookList =document.getElementsByTagName("Book");//collection of child
//        for(int i=0;i<bookList.getLength();i++){
//            Element elementBook =(Element) bookList.item(i);
//            if(elementBook.getAttribute("ID").equals(id)){
//                count++;
//            }
//        }
//        System.out.println(count);
//        return  count;
//
//    }



}
