import java.util.Scanner;

public class snippet3_14 {
    public static void main(String[] args) {
        Scanner N = new Scanner(System.in);
        System.out.println("Enter a number:");
        int intValue = N.nextInt();
        System.out.println("Enter a demical number:");
        float floatValue = N.nextFloat();
        System.out.println("Enter a string value:");
        String strValue = N.next();
        System.out.println("Value entered are:");
        System.out.println(intValue + " " + floatValue + " " + strValue);

    }
}
