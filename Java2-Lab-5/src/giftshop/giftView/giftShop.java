package giftshop.giftView;
import giftshop.giftController.giftController;

import java.util.Scanner;

public class giftShop {
    public static void main(String[] args) {
        giftController g1 = new giftController();
        boolean exit = false;
        int choice = 0;
        Scanner input = new Scanner(System.in);


        while (!exit){
            System.out.println("\n=====GIFT SHOP=====\n");
            System.out.println("1- View gift\n" +
                    "2- Add gift\n" +
                    "3- Delete gift\n" +
                    "4- Exit");
            System.out.printf("Your choice: ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    g1.selectgift();
                    break;
                case 2:
                    g1.insertgift();
                    break;
                case 3:
                    g1.deletegift();
                    break;
                case 4:
                    exit = true;
                    break;
            }
        }
    }
}
