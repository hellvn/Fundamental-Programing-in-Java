package BookRepository;

import java.util.Scanner;

public class TestBook {
    Book[] books;
    byte bookCount;
    public TestBook(){
        bookCount = 0;
    }

    public static void main(String[] args) {
        byte numberOfBook = Byte.parseByte(args[0]);
        TestBook objRepository = new TestBook();

        objRepository.books = new Book[numberOfBook];
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nWelcome to E-Repository.\n Select the operation you want to perform");
            System.out.println("********************************************************");
            System.out.println("1.Add book to the repository");
            System.out.println("2.Search book by Name");
            System.out.println("3.Display books");
            System.out.println("4.Exit");
            System.out.println("*********************************************************");
            choice = input.nextInt();

            switch (choice){
                case 1:
                    objRepository.addBook();
                    break;
                case 2:
                    objRepository.searchBookByName();
                    break;
                case 3:
                    objRepository.DisplayBook();
                case 4:
                    break;
                default:
                    System.out.println("Not a valid choice");
            }
        }while (choice != 4);
    }
    void addBook(){
        Scanner scan = new Scanner(System.in);
        if(bookCount < books.length) {
            books[bookCount] = new Book();
            System.out.println("Enter Book Name: ");
            books[bookCount].name = scan.nextLine();

            System.out.println("Enter Author Name: ");
            books[bookCount].authorName = scan.nextLine();

            System.out.println("Enter Book Price: ");
            books[bookCount].price = scan.nextFloat();

            System.out.println("Enter ISBN of the book:");
            books[bookCount].isbn = scan.nextInt();

            System.out.println("Enter year of publication");
            books[bookCount].yearPublished = scan.nextShort();
            bookCount++;
        }else
            System.out.println("Sorry! unable to add more book");
    }
    void DisplayHeader(){
        System.out.format("%1$-10s %2$-25s %3$-25s %4$-10s %5$-10s","ISBN","Book Name","Author","Price($)","Year of" + "Publication");
    }
    void searchBookByName(){
        Scanner input = new Scanner(System.in);
        String bookName = "";
        boolean bookFound = false;
        if (bookCount > 0){
            DisplayHeader();
            System.out.println("\n------------------------------------------------------------------");
            for (int rowIndex = 0;rowIndex < bookCount;rowIndex++){
                System.out.format("\n%1$-10d %2$-25s %3$-25s %4$-10.2f %5$-10d",
                        books[rowIndex].isbn,
                        books[rowIndex].name,
                        books[rowIndex].authorName,
                        books[rowIndex].price,
                        books[rowIndex].yearPublished);
            }
        }

    }
    void DisplayBook(){
        if (bookCount > 0){
            DisplayHeader();
            System.out.print("\n---------------------------------------------------------------------------");
            for (int rowIndex = 0;rowIndex < bookCount;rowIndex++){
                System.out.format("\n%1$-10d %2$-25s %3$-25s %4$-10.2f %5$-10d",books[rowIndex].isbn,
                        books[rowIndex].name,
                        books[rowIndex].authorName,
                        books[rowIndex].price,
                        books[rowIndex].yearPublished);
            }
        }
    }
}
