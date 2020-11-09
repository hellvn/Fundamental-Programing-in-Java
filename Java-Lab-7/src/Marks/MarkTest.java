package Marks;

import java.util.Scanner;

public class MarkTest {
    public static void main(String[] args) {
        Marks m1 = new Marks();
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\t\t\tMenu:");
            System.out.println("1.Add Mark");
            System.out.println("2.View Mark");
            System.out.println("3.Search by Subject");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    m1.addStudent();
                    break;
                case 2:
                    m1.viewMark();
                    break;
                case 3:
                    m1.searchBySubject();
                default:
                    System.out.println("Enter your choice");
                    break;
            }
        }
        while (choice != 4);
    }
}