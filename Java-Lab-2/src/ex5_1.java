import java.util.Scanner;

public class ex5_1 {
    public static void main(String[] args) {
        int aNumber;
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter a number: ");
        aNumber = input.nextInt();
        if (aNumber >= 0){
            if (aNumber == 0){
                System.out.println("First string");
            }
            else System.out.println("Second string");
        }
        System.out.println("Third string");
    }
}
