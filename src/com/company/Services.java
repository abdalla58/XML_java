package com.company;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Services {
    File file=new File("E:\\FCAI\\4th\\1st term\\SOA\\JAVA ASSIGNMENTS\\FIRST\\data.xml");
    Scanner input = new Scanner(System.in);
    public void create(int numberOfBooks) throws TransformerException, ParserConfigurationException {
        Document document = Helper.createDocument();
        Element Catalogue = document.createElement("Catalogue");
        document.appendChild(Catalogue);
        while (numberOfBooks>0){

            Element book = document.createElement("Book");
            Catalogue.appendChild(book);
            Attr attr = document.createAttribute("ID");
            System.out.println("please Enter book id");
            String id=input.nextLine();
            attr.setValue(id);
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
        Helper.saveToXml(document, String.valueOf(file));
        System.out.println("Done adding books");
    }
    public void appendToXml(int numberOfBooks) throws IOException, SAXException, TransformerException, ParserConfigurationException {
        if (file.exists()){
            Document document =Helper.getDocument();
            Element Catalogue=document.getDocumentElement();
            while (numberOfBooks>0){

                Element book = document.createElement("Book");
                Catalogue.appendChild(book);
                Attr attr = document.createAttribute("ID");
                System.out.println("please Enter book id");
                String id=input.nextLine();
                attr.setValue(id);
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
            Helper.saveToXml(document, String.valueOf(file));
            System.out.println("Done adding books");
        }else{
            System.out.println("There is no file to add data in it please create it first");
            //Menu.createMenu();
            //int numBooks = input.nextInt();
            //create(numBooks);
        }
    }
    public void readAuthorOrTitle(String searchKey) throws IOException, SAXException {
        if (file.exists()){
            Document document =Helper.getDocument();
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
                    }
                }
            }
            if (!check){System.out.println("NOT Found");}
        }else{
            System.out.println("There is no files to read ");
        }

    }
    public void read() throws IOException, SAXException {
        if (file.exists()){
            Document document =Helper.getDocument();
            document.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("Book");
            //System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    //System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    Element eElement = (Element) nNode;
                    System.out.println("Book id: " + eElement.getAttribute("ID"));

                    System.out.println("Author : " + eElement.getElementsByTagName("Author").item(0).getTextContent());

                    System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());

                    System.out.println("Genre : " + eElement.getElementsByTagName("Genre").item(0).getTextContent());

                    System.out.println("Price : "  + eElement.getElementsByTagName("Price").item(0).getTextContent());

                    System.out.println("Publish_Date :" +eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());

                    System.out.println("Description :" +eElement.getElementsByTagName("Description").item(0).getTextContent());
                    System.out.println();
                }
            }
        }else{
            System.out.println("There is no files to read ");
        }
    }
    public void deleteFromXml(String id){
        if (file.exists()){
            Document document =Helper.getDocument();
            NodeList bookList =document.getElementsByTagName("Book");//collection of child
            boolean check=false;
            for(int i=0;i<bookList.getLength();i++){
                Element elementBook =(Element) bookList.item(i);
                //System.out.println(elementBook);
                if(elementBook.getAttribute("ID").equals(id)){
                    elementBook.getParentNode().removeChild(elementBook);
                    check=true;
                }
            }
            Helper.saveToXml(document, String.valueOf(file));
            if (check){
                System.out.println("Book deleted successfully");}
            else{
                System.out.println("ID Not found");
            }
        }else{
            System.out.println("There is no files to delete from it");
        }
    }
//    public void deleteAll(String id) throws ParserConfigurationException {
//        int count =Helper.countDuplicate(id);
//        for (int i=0;i<count;i++){
//            deleteFromXml(id);
//        }
//
//    }
    public Services() throws ParserConfigurationException {
    }
}
