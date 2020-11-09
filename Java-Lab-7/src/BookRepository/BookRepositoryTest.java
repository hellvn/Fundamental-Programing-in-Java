package BookRepository;

import java.util.Scanner;

public class BookRepositoryTest {
    Book[] books;
    byte bookCount;

    public BookRepositoryTest(){
        bookCount = 0;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        BookRepositoryTest obj1 = new BookRepositoryTest();
        do {
            System.out.println("\n Welcome to E-Repository.");
            System.out.println("Select the operation that you want to perform:");
            System.out.println("***********************************************************");
            System.out.println("1. Add book");
            System.out.println("2. Search book by name");
            System.out.println("3. Display all books");
            System.out.println("4. Exit");
            System.out.println("***********************************************************");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    obj1.addBook();
                    break;
                case 2:
                    obj1.searchBookByName();
                    break;
                case 3:
                    obj1.DisplayBook();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Choice ");
                    break;
            }
        }while (choice != 4);

        System.out.println(obj1.toString());

    }
    void addBook(){
        Scanner input = new Scanner(System.in);

        if (bookCount < books.length){
            books[bookCount] = new Book();
            System.out.println("Enter book name:");
            books[bookCount].name = input.nextLine();
            System.out.println("Enter author name:");
            books[bookCount].authorName = input.nextLine();
            System.out.println("Enter book price:");
            books[bookCount].price = input.nextFloat();
            System.out.println("Enter ISBN code:");
            books[bookCount].isbn = input.nextInt();
            System.out.println("Enter year of publication:");
            books[bookCount].yearPublished = input.nextShort();
            bookCount++;
        }
        else
            System.out.println("Can't add more book!");
    }
    void DisplayHeader(){
        System.out.format("%1$-10s %2$-25s %3$-25s %4$-10s %5$-10s","ISBN","Book Name","Author","Price($)","Year of" + "Publication");
    }
    void searchBookByName(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a book name to search for: ");
        String inputname = input.nextLine();
        boolean Found = false;
        if (bookCount > 0){
            DisplayHeader();
            System.out.println("\n____________________________________________________________________________________________________________________________________________");
            for (int index = 0; index < bookCount; index++){
                if (books[index].name == inputname){
                    System.out.printf("%d \t\t ",books[index].isbn);
                    System.out.printf("%s \t\t\t\t",books[index].name);
                    System.out.printf("%s \t\t\t\t",books[index].authorName);
                    System.out.printf("%.2f \t\t",books[index].price);
                    System.out.printf("%d \t\t",books[index].yearPublished);
                    Found = true;
                }
            }
            if (!Found){
                System.out.println("No data about this book name!");
            }
        } else {
            System.out.println("The system is empty!");
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
