import java.util.Scanner;

public class square {
    public static void main(String[] args) {
        int i, j, row, col;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of row: ");
        row = input.nextInt();
        System.out.println("Enter the number of col: ");
        col = input.nextInt();
        for (i = 1; i <= row; ++i) {
            for (j = 1; j <= col; ++j) {
                System.out.print("* ");
            }
            System.out.printf("\n");
        }
    }
}
