package com.company;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class Create {
    public static final String filePath = "E:\\FCAI\\4th\\1st term\\SOA\\JAVA ASSIGNMENTS\\FIRST\\xmlfile.xml";
    Scanner input = new Scanner(System.in);
    public void create(int numberOfBooks) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("Catalogue");
            document.appendChild(root);
            while (numberOfBooks>0){

                Element book = document.createElement("Book");
                root.appendChild(book);
                Attr attr = document.createAttribute("ID");
                attr.setValue("BK101");
                book.setAttributeNode(attr);

                System.out.println("please Enter the Author");
                String tagData1=input.nextLine();
                Element author = document.createElement("Author");
                author.appendChild(document.createTextNode(tagData1));
                book.appendChild(author);

                System.out.println("please Enter the Title");
                String tagData2=input.nextLine();
                Element title = document.createElement("Title");
                title.appendChild(document.createTextNode(tagData2));
                book.appendChild(title);

                System.out.println("please Enter the Genre");
                String tagData3=input.nextLine();
                Element Genre = document.createElement("Genre");
                Genre.appendChild(document.createTextNode(tagData3));
                book.appendChild(Genre);

                System.out.println("please Enter the Price");
                String tagData4=input.nextLine();
                Element Price = document.createElement("Price");
                Price.appendChild(document.createTextNode(tagData4));
                book.appendChild(Price);

                System.out.println("please Enter the Publish_Date");
                String tagData5=input.nextLine();
                Element Publish_Date = document.createElement("Publish_Date");
                Publish_Date.appendChild(document.createTextNode(tagData5));
                book.appendChild(Publish_Date);

                System.out.println("please Enter the Description");
                String tagData6=input.nextLine();
                Element Description = document.createElement("Description");
                Description.appendChild(document.createTextNode(tagData6));
                book.appendChild(Description);
                numberOfBooks--;
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filePath));
            transformer.transform(domSource, streamResult);
            System.out.println("Done adding books");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
