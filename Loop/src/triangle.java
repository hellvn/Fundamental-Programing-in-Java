import java.util.Scanner;

public class triangle {
    public static void main(String[] args) {
        int i, j, max;
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter a number: ");
        max = input.nextInt();
        for (i = 1; i <= max; ++i){
            for (j = 1; j <= i; ++j){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
