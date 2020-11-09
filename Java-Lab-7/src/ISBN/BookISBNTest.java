package ISBN;

import java.util.Scanner;

public class BookISBNTest {

    public BookISBNTest(){
        int ISBN[] = new int[5];
        int temp = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter five ISBN numbers:");
        for (int i =0; i < ISBN.length; i++){
            ISBN[i] = input.nextInt();
        }

        System.out.println("\nThe ISBN numbers of the book are:");
        for (int i =0; i< ISBN.length; i++){
            System.out.println(ISBN[i]);
        }

        for (int i = 0; i< ISBN.length; i++){
            for (int j = 0; j< ISBN.length; j++){
                if (ISBN[i]<ISBN[j]){
                    temp = ISBN[i];
                    ISBN[i] = ISBN[j];
                    ISBN[j] = temp;
                }
            }
        }
        System.out.println("\nThe ISBN numbers of the book in ascending order are:");
        for (int i = 0; i < ISBN.length; i++){
            System.out.println(ISBN[i]);
        }

    }
    public static void main(String[] args) {
        BookISBNTest I1 = new BookISBNTest();

    }
}
