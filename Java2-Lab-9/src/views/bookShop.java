package views;

import controllers.BookControler;

import java.util.Scanner;

public class BookShop {

    public static void main(String[] args) {
        BookControler bm1 = new BookControler();
        CartView cv1 = new CartView();
        Scanner input = new Scanner(System.in);
        boolean quit = false;

        System.out.println("=====WELCOME TO E-BOOK SHOP!=====");
        bm1.ViewBook();
        visitmenu();
        while (!quit){
            System.out.printf("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:
                    cv1.AddToCart();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Good Bye!");
                    quit = true;
            }

        }

    }
    private static void visitmenu(){
        System.out.println("1 - Take A book\n" +
                "2 - Login\n" +
                "3 - Register\n" +
                "4 - Quit");
    }
}