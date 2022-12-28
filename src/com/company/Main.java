package com.company;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {

        Services service = new Services();
        Scanner input = new Scanner(System.in);
        label:
        while (true){
            Menu.mainMenu();
            String choice= input.next();
            switch (choice) {
                case "1": {
                    Menu.createMenu();
                    int numberOfBooks = input.nextInt();
                    service.create(numberOfBooks);
                    break;
                }
                case "2": {
                    Menu.createMenu();
                    int numberOfBooks = input.nextInt();
                    service.appendToXml(numberOfBooks);
                    break;
                }
                case "3":
                    Menu.readMenu();
                    String read = input.next();
                    if (read.equals("1")) {
                        service.read();
                    } else if (read.equals("2")) {
                        Menu.readAuthorOrTitle();
                        String searchKey = input.next();
                        service.readAuthorOrTitle(searchKey);
                    }
                    break;
                case "4":
                    Menu.deleteMenu();
                    String bookId = input.next();
                    service.deleteFromXml(bookId);
                    break;
                case "5":
                    Menu.exit();
                    break label;
            }
        }
    }
}

