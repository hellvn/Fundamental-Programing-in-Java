package Marks;

import java.util.Scanner;

public class Marks {
    int Mark[][];
    int Studen = 0;

    public Marks(){
        Mark = new int[5][4];
        Studen = 0;
    }
    void addStudent(){
        Scanner input = new Scanner(System.in);

        if (Studen < Mark.length){
            System.out.println("Enter mark of subject 01:");
            Mark[Studen][0] = input.nextInt();

            System.out.println("Enter mark of subject 02:");
            Mark[Studen][1] = input.nextInt();

            System.out.println("Enter mark of subject 03:");
            Mark[Studen][2] = input.nextInt();

            System.out.println("Enter mark of subject 04:");
            Mark[Studen][3] = input.nextInt();

            Studen++;
        }
        else
            System.out.println("Student list is full!");
    }
    void viewMark(){
        if (Studen>0){
            System.out.println("\nSubject01\tSubject02\tSubject03\tSubject04");
            System.out.println("--------------------------------------------");

            for (int i = 0; i< Studen; i++){
                System.out.printf("\t%d\t\t\t", Mark[i][0]);
                System.out.printf("%d\t\t\t", Mark[i][1]);
                System.out.printf("%d\t\t\t", Mark[i][2]);
                System.out.printf("%d\n", Mark[i][3]);
            }
        }
        else System.out.println("No student to view!");
    }

    void searchBySubject(){
        if (Studen>0){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Subject code to Search:\n 1: Subject 01.\n2: Subject 02.\n3: Subject 03\n4: Subject 04\n");
            int subCode = input.nextInt();
            if (subCode<= Mark.length){
                System.out.println("Subject0"+subCode);
                for (int i = 0; i < Studen; i++){
                    System.out.printf("\t%d\n", Mark[i][subCode-1]);
                }
            }
            else
                System.out.println("Subject not found");
        }
        else
            System.out.println("No data");
    }
}
