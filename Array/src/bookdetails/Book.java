package bookdetails;

import java.util.Scanner;

public class Book {
    int books[][];
    byte bookCount;

    public Book(){
        books = new int[3][3];
        bookCount = 0;
    }
    void addBook(){
        Scanner input = new Scanner(System.in);

        if (bookCount < books.length){
            System.out.printf("\nEnter the ISBN number of the book: ");
            books[bookCount][0] = input.nextInt();

            System.out.printf("\nEnter the number of pages in the book: ");
            books[bookCount][1] = input.nextInt();

            System.out.printf("\nEnter the year of publication: ");
            books[bookCount][2] = input.nextInt();

            bookCount++;
        }
        else {
            System.out.println("Sorry! the book sell is not enough space.\n");
        }
    }
    void displayBook(){
        if (bookCount>0){
            System.out.println("\n ISBN\t\tPages\t\tYear");
            System.out.println("------------------------");

            for (int row = 0; row<bookCount; row++){
                System.out.printf("%d\t\t", books[row][0]);
                System.out.printf("%d\t\t", books[row][1]);
                System.out.printf("%d\n", books[row][2]);
            }
        }
        else {
            System.out.println("No book to display!");
        }
    }
    void searchByIsbn(){
        boolean found = false;

        if (bookCount>0){
            Scanner input = new Scanner(System.in);
            System.out.printf("Enter ISBN number to search: ");
            int searchIsbn = input.nextInt();
            System.out.println("\n ISBN\t\tPages\t\tYear");
            System.out.println("------------------------");

            for (int row = 0; row<bookCount; row++){
                if (books[row][0] == searchIsbn){
                    System.out.printf("%d\t\t", books[row][0]);
                    System.out.printf("%d\t\t", books[row][1]);
                    System.out.printf("%d\n", books[row][2]);
                    found = true;
                    break;
                }
            }
            if (!found)
                System.out.println("Book not found.");
            else
                System.out.println("No book to search");
        }
    }
    void searchByYear(){
        boolean found = false;

        if (bookCount > 0){
            Scanner input = new Scanner(System.in);
            System.out.printf("\nEnter the publication of book to search: ");
            int pubYear = input.nextInt();
            System.out.println("\n ISBN\t\tPages\t\tYear");
            System.out.println("------------------------");

            for (int row = 0; row<bookCount; row++){
                if (books[row][2] == pubYear){
                    System.out.printf("%d\t\t", books[row][0]);
                    System.out.printf("%d\t\t", books[row][1]);
                    System.out.printf("%d\n", books[row][2]);
                    found = true;
                }
            }
            if (!found)
                System.out.println("Book not found.");
        }
        else
            System.out.println("No book to search.");
    }
}
