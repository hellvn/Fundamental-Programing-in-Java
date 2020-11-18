package views;

import controllers.BookControler;
import controllers.CartControler;
import models.CartModel;

import java.util.Scanner;

public class CartView {
    Scanner input = new Scanner(System.in);
    BookControler bc1 = new BookControler();
    CartControler cartControler = new CartControler();
    public int BookID, Amount;
    public void AddToCart(){
        char choice = 'n';
        do {
            System.out.printf("Enter Book ID: ");
            BookID = input.nextInt();
            if (BookID != bc1.bookID)
            System.out.printf("Enter Amount: ");
            Amount = input.nextInt();
            if (Amount>bc1.qty){
                System.out.println("Book qty is not enough");
            }
            else {
                CartModel newItem = new CartModel(BookID, Amount);
                if (cartControler.addToCart(newItem)) {
                    System.out.println("Book added to cart!");
                } else {
                    System.out.println("Please take another book");
                }
                System.out.printf("Buy more book? (Y/N): ");
                choice = input.next().charAt(0);
            }
        }
        while (choice == 'y');

    }
}
