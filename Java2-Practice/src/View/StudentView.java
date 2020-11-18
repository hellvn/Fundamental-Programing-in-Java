package View;

import Controler.StudentControl;
import java.util.Scanner;

public class StudentView {
    public static void main(String[] args) {
        StudentControl sctrl = new StudentControl();
        Scanner input = new Scanner(System.in);
        int choice;
        boolean exit = false;
        while (!exit){
            System.out.println("=====Student====\n" +
                    "1 - Add Student Records\n" +
                    "2 - Display Student Records\n" +
                    "3 - Save\n" +
                    "4 - Exit");
            System.out.printf("Your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:
                    sctrl.AddStudent();
                    break;
                case 2:
                    sctrl.DisplayRecord();
                    break;
                case 3:
                    sctrl.SaveStudent();
                    break;
                case 4:
                    System.out.println("Disconecting...");
                    exit = true;
                    break;
            }
        }

    }
}
