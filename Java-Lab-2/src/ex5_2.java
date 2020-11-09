import java.util.Scanner;

public class ex5_2 {
    public static void main(String[] args) {
        int menu,num1, num2;
        char answer = 'y';
        while (answer == 'y'){
            System.out.println("THE CALCULATOR");
            System.out.printf("\n Menu: \n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n");
            Scanner input = new Scanner(System.in);
            System.out.printf("Enter your choice: ");
            menu = input.nextInt();

            switch (menu){
                case 1:
                    System.out.println("\nEnter the First Number: ");
                    num1 = input.nextInt();
                    System.out.println("\nEnter the Second Number: ");
                    num2 = input.nextInt();
                    System.out.printf("The Addition of %d and %d is %d",num1,num2, num1+num2);
                    break;
                case 2:
                    System.out.println("\nEnter the First Number: ");
                    num1 = input.nextInt();
                    System.out.println("\nEnter the Second Number: ");
                    num2 = input.nextInt();
                    System.out.printf("The Subtraction of %d and %d is %d",num1,num2, num1-num2);
                    break;
                case 3:
                    System.out.println("\nEnter the First Number: ");
                    num1 = input.nextInt();
                    System.out.println("\nEnter the Second Number: ");
                    num2 = input.nextInt();
                    System.out.printf("The Multiplication of %d and %d is %d",num1,num2, num1*num2);
                    break;
                case 4:
                    System.out.println("\nEnter the First Number: ");
                    num1 = input.nextInt();
                    System.out.println("\nEnter the Second Number: ");
                    num2 = input.nextInt();
                    System.out.printf("The Division of %d and %d is %d",num1,num2, num1/num2);
                    break;
                default:
                    System.out.println("\nInvalid choice!");
            }
            System.out.println("\nContinue? (Y/N)");
            answer = input.next().charAt(0);
        }
    }
}
