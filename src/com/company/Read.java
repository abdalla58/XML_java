package com.company;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Read {
    File inputFile = new File("E:\\FCAI\\4th\\1st term\\SOA\\JAVA ASSIGNMENTS\\FIRST\\data.xml");
    public void read(String searchKey){
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputFile);
            document.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("Book");
            //System.out.println("----------------------------");
            boolean check=false;
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    //System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    Element eElement = (Element) nNode;
                    String author = eElement.getElementsByTagName("Author").item(0).getTextContent();
                    String title = eElement.getElementsByTagName("Title").item(0).getTextContent();
                    if (author.contains( searchKey ) || title.contains(searchKey)){
                        check=true;
                        System.out.println("Book id: " + eElement.getAttribute("ID"));

                        System.out.println("Author : " + eElement.getElementsByTagName("Author").item(0).getTextContent());

                        System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());

                        System.out.println("Genre : " + eElement.getElementsByTagName("Genre").item(0).getTextContent());

                        System.out.println("Price : "  + eElement.getElementsByTagName("Price").item(0).getTextContent());

                        System.out.println("Publish_Date :" +eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());

                        System.out.println("Description :" +eElement.getElementsByTagName("Description").item(0).getTextContent());
                    }else{
                        check=false;
                    }
                }
            }
            if (!check){System.out.println("NOT Found");}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
