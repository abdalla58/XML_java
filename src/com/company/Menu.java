package com.company;

public class Menu {
    public static void mainMenu(){
        System.out.println("Please select number of service");
        System.out.println("1-create new books");
        System.out.println("2-append to old books");
        System.out.println("3-read books");
        System.out.println("4-delete book");
        System.out.println("5-Exit");
    }
    public static void readMenu(){
        System.out.println("1-Read all Books");
        System.out.println("2-Read with specific Author or title");
    }
    public static void readAuthorOrTitle(){
        System.out.println("Please Enter Author name or Title");
    }
    public static void createMenu(){
        System.out.println("Please Enter the number of books that you want to add");
    }
    public static void deleteMenu(){
        System.out.println("Please Enter the id of books that you want to delete");
    }
    public static void exit(){
        System.out.println("Thank you for using our service");
    }

}
