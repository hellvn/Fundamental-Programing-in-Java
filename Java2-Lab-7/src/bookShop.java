import java.util.Scanner;

public class bookShop {
    public static void main(String[] args) throws InterruptedException {
        bookcontroler b1 = new bookcontroler();
        int choice;
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        while (!quit){
            System.out.println("1- login\n" +
                    "2- Register\n" +
                    "3- Quit");
            System.out.printf("Your choice: ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    b1.login();
                    break;
                case 2:
                    b1.regist();
                    break;
                case 3:
                    quit =  true;
                    break;
            }
        }
    }
}
