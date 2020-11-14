package views;

import controllers.bookcontroler;
import java.util.Scanner;
import models.*;

public class bookShop {
    private static String username = "";
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        bookShop bookShop1 = new bookShop();
        System.out.println("=====Welcome "+username +" to ebook shop!=====");
        bookShop1.normalmenu();
    }

    private void normalmenu() {

        int choice;
        char cont ='n';
        boolean quit = false;
        while (!quit) {
            System.out.println("=====MENU=====\n" +
                    "1- Display all book\n" +
                    "2- Search a book\n" +
                    "3- Show top 10 new book\n" +
                    "4- Show top 10 sold book\n" +
                    "5- Quit");
            System.out.printf("Your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    bookcontroler bookcontroler1 = new bookcontroler();
                    bookcontroler1.displayBook();
                    System.out.printf("Buy a book?(Y/N): ");
                    cont = input.next().charAt(0);
                    if (cont == 'y' || cont == 'Y'){
                        cartview.addtocart(new cart());
                    }
                    break;
                case 2:
                    ;
                    break;
                case 3:

                case 5:
                    quit = true;
                    break;
            }
        }
    }
//    public  void superadminmenu(){
//        int choice;
//        boolean quit = false;
//        Scanner input = new Scanner(System.in);
//        while (!quit) {
//            System.out.println("1- Set role\n" +
//                    "2- Delete member\n" +
//                    "3- Add book\n" +
//                    "4- Logout");
//            System.out.printf("Your choice: ");
//            choice = input.nextInt();
//            switch (choice) {
//                case 1:
//                    setrolesupper();
//                    break;
//                case 2:
//                    top100selled();
//                    break;
//                case 3:
//                    addbook();
//                    break;
//                case 4:
//                    quit = true;
//                    break;
//            }
//        }
//    }
//    public void adminmenu() {
//        int choice;
//        boolean quit = false;
//        Scanner input = new Scanner(System.in);
//        while (!quit) {
//            System.out.println("1- Set role\n" +
//                    "2- Delete member\n" +
//                    "3- Add book\n" +
//                    "4- Logout");
//            System.out.printf("Your choice: ");
//            choice = input.nextInt();
//            switch (choice) {
//                case 1:
//                    setrole();
//                    break;
//                case 2:
//                    top100selled();
//                    break;
//                case 3:
//                    addbook();
//                    break;
//                case 4:
//                    quit = true;
//                    break;
//            }
//        }
//    }
//    public void vipmenu() {
//        int choice;
//        boolean quit = false;
//        Scanner input = new Scanner(System.in);
//        while (!quit) {
//            System.out.println("1- Top 10 newest book\n" +
//                    "2- Top 100 selled book\n" +
//                    "3- Order book\n" +
//                    "4- Logout");
//            System.out.printf("Your choice: ");
//            choice = input.nextInt();
//            switch (choice) {
//                case 1:
//
//                    break;
//                case 2:
//                    top100selled();
//                    break;
//                case 3:
//                    orderbook();
//                    break;
//                case 4:
//                    quit = true;
//                    break;
//            }
//        }
//    }
}
